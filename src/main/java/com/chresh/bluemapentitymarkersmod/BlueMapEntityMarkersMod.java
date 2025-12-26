package com.chresh.bluemapentitymarkersmod;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chresh.bluemapentitymarkersmod.entity.EntityEntry;
import com.chresh.bluemapentitymarkersmod.entity.EntityManager;
import com.chresh.bluemapentitymarkersmod.util.Constants;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;


public class BlueMapEntityMarkersMod implements DedicatedServerModInitializer {

	private ScheduledExecutorService scheduler;
	private static final Logger LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

	@Override
	public void onInitializeServer() {
		ServerLifecycleEvents.SERVER_STARTING.register(this::onServerStarting);
		ServerLifecycleEvents.SERVER_STOPPING.register(this::onServerStopping);

		ServerLifecycleEvents.SERVER_STARTED.register(this::markerRunner);
	}

	private void markerRunner(MinecraftServer server) {
		Box TheBox = new Box(BlockPos.ORIGIN).expand(12000);
		ArrayList<EntityEntry> entityEntries = new ArrayList<>();
		
		//org.apache.logging.log4j.core.config.Configurator.setLevel(Constants.MOD_ID, Level.DEBUG);

		if (server != null) {
		//MinecraftServer server = MinecraftClient.getInstance().getServer();

		this.scheduler = Executors.newScheduledThreadPool(1); // 1 is the size of the thread pool being created

        scheduler.scheduleAtFixedRate(() -> {
				for (EntityEntry entityEntry : entityEntries) {
					EntityManager.remove(entityEntry);
				}
				entityEntries.clear();
				
            	server.getWorlds().forEach(world -> {
					world.getEntitiesByClass(Entity.class, TheBox, Predicate.not(Entity::isRemoved)).forEach(entity -> {

					LOGGER.debug("Entity...: {}, World {}", entity, entity.getWorld().getRegistryKey().getValue());
					LOGGER.debug("Entity info: isSkyVisible {}, has skylight {}, has Ceiling {}", entity.getWorld().isSkyVisible(entity.getBlockPos()), entity.getWorld().getDimension().hasSkyLight(), entity.getWorld().getDimension().hasCeiling());
					
					
					//if (entity.getWorld().isSkyVisible(entity.getBlockPos()) || !entity.getWorld().getDimension().hasSkyLight() || entity.getWorld().getDimension().hasCeiling()){
						
						entityEntries.add(new EntityEntry(
						entity.getPos(),
						entity.getType(),
						entity.getUuid(),
						entity.getDisplayName().copyContentOnly().getString(),
						entity.getWorld(),
						entity.getBlockPos().getX(),
						entity.getBlockPos().getY(),
						entity.getBlockPos().getZ(),
						entity.getDimensions(entity.getPose())
					));
				
					//}
				}
			);
			});
			for (EntityEntry entityEntry : entityEntries) {
				EntityManager.addOrUpdate(entityEntry);
			}
        },3, 3, TimeUnit.SECONDS); 


		}
	}
	public void shutdown() {
		this.scheduler.shutdownNow();
		EntityManager.stop();
	}

	private void onServerStarting(MinecraftServer server) {

	}

	private void onServerStopping(MinecraftServer server) {
		shutdown();
	}
}

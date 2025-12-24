package com.chresh.bluemapentitymarkersmod.entity;

import java.util.UUID;

import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public record EntityEntry(
        Vec3d pos, EntityType<?> type, UUID uuid, String simpleName, World world, int x,
            int y, int z) {


                

                public Vec3d getPos() {
                    return pos;
                }
                public EntityType<?> getType() {
                    return type;
                }
                public UUID getUuid() {
                    return uuid;
                }
                public String getSimpleName() {
                    return simpleName;
                }
                public World getWorld() {
                    return world;
                }
                public String getWorldKey() {
                    if (world == null) {
                        return "unknown";
                    }
                    return world.getRegistryKey().getValue().toString();
                }
                public int getX() {
                    return x;
                }
                public int getY() {
                    return y;
                }
                public int getZ() {
                    return z;
                }
}

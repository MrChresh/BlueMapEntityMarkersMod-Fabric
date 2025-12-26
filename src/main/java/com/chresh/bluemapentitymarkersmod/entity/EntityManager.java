package com.chresh.bluemapentitymarkersmod.entity;

import com.chresh.bluemapentitymarkersmod.actions.ActionFactory;
import com.chresh.bluemapentitymarkersmod.markers.MarkerSetIdentifierCollection;
import com.chresh.bluemapentitymarkersmod.util.BlueMapAPIConnector;
import com.chresh.bluemapentitymarkersmod.util.IResetHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class EntityManager implements IResetHandler {
    private static EntityManager instance;
    private static final Object mutex = new Object();

    private static EntityManager getInstance() {
        EntityManager result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new EntityManager();
                }
            }
        }
        return result;
    }

    public static void addOrUpdate(EntityEntry entityEntry) {
        getInstance().addOrUpdateEntity(entityEntry);
    }
    public static void remove(EntityEntry entityEntry) {
        getInstance().removeEntity(entityEntry);
    }

    public static List<EntityEntry> getAll() {
        return getInstance().getAllEntities();
    }
    public static void stop() {
        getInstance().shutdown();
    }

    private final BlueMapAPIConnector blueMapAPIConnector;
    private final ActionFactory actionFactory;
    private final ConcurrentMap<EntityEntryKey, EntityEntry> entityCache = new ConcurrentHashMap<>();

    private EntityManager() {
        MarkerSetIdentifierCollection markerSetIdentifierCollection = new MarkerSetIdentifierCollection();
        actionFactory = new ActionFactory(markerSetIdentifierCollection);
        blueMapAPIConnector = new BlueMapAPIConnector();
        
        blueMapAPIConnector.addResetHandler(this);
    }

    private List<EntityEntry> getAllEntities() {
        return new ArrayList<>(entityCache.values());
    }

    private void shutdown() {
        blueMapAPIConnector.shutdown();
    }

    private void removeEntity(EntityEntry entityEntry) {
        blueMapAPIConnector.dispatch(
                actionFactory.createRemoveExtrudeAction(entityEntry));
            return;
    }

    private void addOrUpdateEntity(EntityEntry entityEntry) {;
            blueMapAPIConnector.dispatch(
                    actionFactory.createAddExtrudeAction(entityEntry));
            return;
        }



    @Override
    public void reset() {
        //reloadSigns();
    }
}

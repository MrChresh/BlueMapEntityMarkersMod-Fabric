package com.chresh.bluemapentitymarkersmod.actions;

import com.chresh.bluemapentitymarkersmod.entity.EntityEntry;
import com.chresh.bluemapentitymarkersmod.markers.MarkerGroup;
import com.chresh.bluemapentitymarkersmod.markers.MarkerGroupType;
import com.chresh.bluemapentitymarkersmod.markers.MarkerIdentifier;
import com.chresh.bluemapentitymarkersmod.markers.MarkerSetIdentifierCollection;

public class ActionFactory {
    private final MarkerSetIdentifierCollection markerSetIdentifierCollection;

    public ActionFactory(MarkerSetIdentifierCollection markerSetIdentifierCollection) {
        this.markerSetIdentifierCollection = markerSetIdentifierCollection;
    }

    public AddMarkerAction createAddExtrudeAction(EntityEntry entityEntry) {
        return new AddMarkerAction(
                new MarkerIdentifier(
                        entityEntry.getX(),
                        entityEntry.getY(),
                        entityEntry.getZ(),
                        markerSetIdentifierCollection.getIdentifier(entityEntry.getWorldKey(), new MarkerGroup("", MarkerGroupType.Extrude, "Entity", "", 0, 0))),
                        entityEntry);
    }

    public RemoveMarkerAction createRemoveExtrudeAction(EntityEntry entityEntry) {
        return new RemoveMarkerAction(
                new MarkerIdentifier(
                        entityEntry.getX(),
                        entityEntry.getY(),
                        entityEntry.getZ(),
                        markerSetIdentifierCollection.getIdentifier(entityEntry.getWorldKey(), new MarkerGroup("", MarkerGroupType.Extrude, "Entity", "", 0, 0))));
    }

    public UpdateMarkerAction createUpdateExtrudeAction(EntityEntry entityEntry) {
        return new UpdateMarkerAction(
                new MarkerIdentifier(
                        entityEntry.getX(),
                        entityEntry.getY(),
                        entityEntry.getZ(),
                        markerSetIdentifierCollection.getIdentifier(entityEntry.getWorldKey(), new MarkerGroup("", MarkerGroupType.Extrude, "Entity", "", 0, 0))),
                entityEntry);
    }


}

package com.chresh.bluemapentitymarkersmod.actions;

import com.chresh.bluemapentitymarkersmod.entity.EntityEntry;
import com.chresh.bluemapentitymarkersmod.markers.MarkerIdentifier;

import net.minecraft.entity.EntityDimensions;

public class UpdateMarkerAction extends MarkerAction {
    private final String newLabel;
    private final String newDetails;
    private final EntityDimensions entityDimensions;
    
    public UpdateMarkerAction(MarkerIdentifier markerIdentifier, EntityEntry entityEntry) {
        super(markerIdentifier);
        this.newLabel = entityEntry.getSimpleName();
        this.newDetails = entityEntry.getSimpleName();
        this.entityDimensions = entityEntry.getDimensions();
    }

    public String getNewLabel() {
        return newLabel;
    }

    public String getNewDetails() {
        return newDetails;
    }

    public EntityDimensions getEntityDimensions() {
        return entityDimensions;
    }
    @Override
    public String toString() {
        return "UpdateMarkerAction{" +
                "markerIdentifier=" + getMarkerIdentifier() +
                ", newLabel='" + newLabel + '\'' +
                ", newDetails='" + newDetails + '\'' +
                '}';
    }
}
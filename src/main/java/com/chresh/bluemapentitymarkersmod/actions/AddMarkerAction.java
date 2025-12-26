package com.chresh.bluemapentitymarkersmod.actions;


import com.chresh.bluemapentitymarkersmod.entity.EntityEntry;
import com.chresh.bluemapentitymarkersmod.markers.MarkerIdentifier;

import net.minecraft.entity.EntityDimensions;

public class AddMarkerAction extends MarkerAction {
    private final String label;
    private final String detail;
    private final EntityDimensions entityDimensions;


    public AddMarkerAction(MarkerIdentifier markerIdentifier, EntityEntry entityEntry) {
        super(markerIdentifier);
        this.label = entityEntry.getSimpleName();
        this.detail = entityEntry.getSimpleName();
        this.entityDimensions = entityEntry.getDimensions();
    }

    public String getLabel() {
        return label;
    }

    public String getDetail() {
        return detail;
    }
    public EntityDimensions getEntityDimensions() {
        return entityDimensions;
    }

    @Override
    public String toString() {
        return "AddMarkerAction{" +
                "markerIdentifier=" + getMarkerIdentifier() +
                ", label='" + label + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

}
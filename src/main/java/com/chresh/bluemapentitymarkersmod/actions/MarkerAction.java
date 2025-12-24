package com.chresh.bluemapentitymarkersmod.actions;

import com.chresh.bluemapentitymarkersmod.markers.MarkerIdentifier;

public abstract class MarkerAction {
    private final MarkerIdentifier markerIdentifier;

    protected MarkerAction(MarkerIdentifier markerIdentifier) {
        this.markerIdentifier = markerIdentifier;
    }

    public MarkerIdentifier getMarkerIdentifier() {
        return markerIdentifier;
    }

    public double getX() {
        return markerIdentifier.x();
    }

    public double getY() {
        return markerIdentifier.y();
    }

    public double getZ() {
        return markerIdentifier.z();
    }

    @Override
    public String toString() {
        return "MarkerAction{" +
                "markerIdentifier=" + markerIdentifier +
                '}';
    }
}

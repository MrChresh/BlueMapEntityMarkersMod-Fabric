package com.chresh.bluemapentitymarkersmod.actions;

import com.chresh.bluemapentitymarkersmod.markers.MarkerIdentifier;

public class RemoveMarkerAction extends MarkerAction {
    public RemoveMarkerAction(MarkerIdentifier markerIdentifier) {
        super(markerIdentifier);
    }

    @Override
    public String toString() {
        return "RemoveMarkerAction{" +
                "markerIdentifier=" + getMarkerIdentifier() +
                '}';
    }
}
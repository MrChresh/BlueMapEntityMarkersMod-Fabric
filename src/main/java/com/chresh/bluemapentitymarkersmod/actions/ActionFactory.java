package com.chresh.bluemapentitymarkersmod.actions;

import com.chresh.bluemapentitymarkersmod.markers.MarkerGroup;
import com.chresh.bluemapentitymarkersmod.markers.MarkerGroupType;
import com.chresh.bluemapentitymarkersmod.markers.MarkerIdentifier;
import com.chresh.bluemapentitymarkersmod.markers.MarkerSetIdentifierCollection;

public class ActionFactory {
    private final MarkerSetIdentifierCollection markerSetIdentifierCollection;

    public ActionFactory(MarkerSetIdentifierCollection markerSetIdentifierCollection) {
        this.markerSetIdentifierCollection = markerSetIdentifierCollection;
    }

    public AddMarkerAction createAddPOIAction(int x, int y, int z, String worldKey, String uuid, String simpleName) {
        return new AddMarkerAction(
                new MarkerIdentifier(
                        x,
                        y,
                        z,
                        markerSetIdentifierCollection.getIdentifier(worldKey, new MarkerGroup("", MarkerGroupType.POI, "", "", 0, 0))),
                uuid,
                simpleName);
    }

    public RemoveMarkerAction createRemovePOIAction(int x, int y, int z, String worldKey, String uuid, String simpleName) {
        return new RemoveMarkerAction(
                new MarkerIdentifier(
                        x,
                        y,
                        z,
                        markerSetIdentifierCollection.getIdentifier(worldKey, new MarkerGroup("", MarkerGroupType.POI, "", "", 0, 0))));
    }

    public UpdateMarkerAction createUpdatePOIAction(int x, int y, int z, String worldKey, String uuid, String simpleName) {
        return new UpdateMarkerAction(
                new MarkerIdentifier(
                        x,
                        y,
                        z,
                        markerSetIdentifierCollection.getIdentifier(worldKey, new MarkerGroup("", MarkerGroupType.POI, "", "", 0, 0))),
                uuid,
                simpleName);
    }


}

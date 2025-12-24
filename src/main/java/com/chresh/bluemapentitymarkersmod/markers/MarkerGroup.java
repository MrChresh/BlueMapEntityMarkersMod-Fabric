package com.chresh.bluemapentitymarkersmod.markers;

public record MarkerGroup(String prefix, MarkerGroupType type, String name, String icon, int offsetX, int offsetY) {
    public MarkerGroup withType(MarkerGroupType type) {
        return new MarkerGroup(prefix, type, name, icon, offsetX, offsetY);
    }
}

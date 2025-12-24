package com.chresh.bluemapentitymarkersmod.entity;

public record EntityEntryKey(
        int x,
        int y,
        int z,
        String parentMap) {


    public EntityEntryKey withParentMap(String parentMap) {
        return new EntityEntryKey(x, y, z, parentMap);
    }
}

package com.chresh.bluemapentitymarkersmod.util;

import com.chresh.bluemapentitymarkersmod.entity.EntityLinesParseResult;
import com.chresh.bluemapentitymarkersmod.markers.MarkerGroup;

public class ParsingContext {
    private MarkerGroup markerGroup;
    private String label;
    private final StringBuilder detailBuilder;

    public ParsingContext() {
        this.markerGroup = null;
        this.label = "";
        this.detailBuilder = new StringBuilder();
    }

    public void setMarkerGroup(MarkerGroup markerGroup) {
        this.markerGroup = markerGroup;
    }

    public MarkerGroup getMarkerGroup() {
        return this.markerGroup;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void appendDetail(String detail) {
        this.detailBuilder.append(detail).append("\n");
    }

    public EntityLinesParseResult buildResult() {
        if (this.markerGroup == null) {
            return new EntityLinesParseResult(null, "", "");
        }

        return new EntityLinesParseResult(this.markerGroup.prefix(), this.label, this.detailBuilder.toString().trim());
    }
}

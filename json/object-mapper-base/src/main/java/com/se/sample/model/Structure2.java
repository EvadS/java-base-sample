package com.se.sample.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Structure2 {

    @JsonProperty("isVisited")
    private String isVisited;
    @JsonProperty("anchor")
    private String anchor;
    @JsonProperty("parent_anchor")
    private String parentAnchor;
    @JsonProperty("value")
    private String value;
    @JsonProperty("isBold")
    private String isBold;

    @JsonProperty("isVisited")
    public String getIsVisited() {
        return isVisited;
    }

    @JsonProperty("isVisited")
    public void setIsVisited(String isVisited) {
        this.isVisited = isVisited;
    }

    @JsonProperty("anchor")
    public String getAnchor() {
        return anchor;
    }

    @JsonProperty("anchor")
    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    @JsonProperty("parent_anchor")
    public String getParentAnchor() {
        return parentAnchor;
    }

    @JsonProperty("parent_anchor")
    public void setParentAnchor(String parentAnchor) {
        this.parentAnchor = parentAnchor;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("isBold")
    public String getIsBold() {
        return isBold;
    }

    @JsonProperty("isBold")
    public void setIsBold(String isBold) {
        this.isBold = isBold;
    }
}

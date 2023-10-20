package com.se.sample.model;

import com.fasterxml.jackson.annotation.*;
import com.se.sample.model.Structure;
import com.se.sample.model.Structure2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Example {

    @JsonProperty("structure_blocks")
    private List<Object> structureBlocks;
    @JsonProperty("structure")
    private List<Structure2> structure;

    @JsonProperty("structure_blocks")
    public List<Object> getStructureBlocks() {
        return structureBlocks;
    }

    @JsonProperty("structure_blocks")
    public void setStructureBlocks(List<Object> structureBlocks) {
        this.structureBlocks = structureBlocks;
    }

    @JsonProperty("structure")
    public List<Structure2> getStructure() {
        return structure;
    }

    @JsonProperty("structure")
    public void setStructure(List<Structure2> structure) {
        this.structure = structure;
    }
}
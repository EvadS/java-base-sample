package org.example.paragraph;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder(withPrefix = "")
public class DocumentBlockBuilder {

    private BlockType blockType;
    private BlockText blockText;
    private String css;
    private String attributes;

    public DocumentBlockBuilder blockType(BlockType blockType) {
        this.blockType = blockType;
        return this;
    }

    public DocumentBlockBuilder blockText(BlockText blockText) {
        this.blockText = blockText;
        return this;
    }

    public DocumentBlockBuilder css(String css) {
        this.css = css;
        return this;
    }

    public DocumentBlockBuilder attributes(String attributes) {
        this.attributes = attributes;
        return this;
    }

    public DocumentBlock build() {
        return new DocumentBlock(blockType, blockText, css, attributes);
    }
}

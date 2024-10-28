package org.example.paragraph;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * базовый класс блочка текста
 */


@JsonDeserialize(builder = DocumentBlockBuilder.class)
public class DocumentBlock {

    private BlockType blockType;
    private BlockText blockText;
    private String css;
    private String attributes;


    public DocumentBlock() {
    }

    /**
     *
     * @param blockType
     * @param blockText
     * @param css
     * @param attributes

     */
    public DocumentBlock(BlockType blockType, BlockText blockText,
                         String css, String attributes) {
        this.blockType = blockType;
        this.blockText = blockText;
        this.css = css;
        this.attributes = attributes;
    }

    public static DocumentBlockBuilder builder() {
        return new DocumentBlockBuilder();
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }

    public BlockText getBlockText() {
        return blockText;
    }

    public void setBlockText(BlockText blockText) {
        this.blockText = blockText;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "DocumentBlockBase{" +
                "blockType=" + blockType +
                ", blockText=" + blockText +
                ", css='" + css + '\'' +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}

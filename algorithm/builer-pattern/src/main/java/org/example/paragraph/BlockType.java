package org.example.paragraph;

public enum BlockType {
    TEXT(0, "text"),
    TABLE(1, "table"),
    TEXT_IMAGE(3, "image");

    private final int id;
    private final  String name;

    BlockType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

package org.example.paragraph;

public class BlockText  {
    private String value;

    public BlockText() {
    }

    public BlockText(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

package com.se.sample.demo1;

import java.util.UUID;

public class TreeNode {
    public UUID Tag;
    private  String Text;

    public TreeNode(String s, UUID guid) {
        this.Text = s;
        this.Tag = guid;
    }

    public String getText() {
        return Text;
    }
}

package com.se.sample.demo1;

import java.util.UUID;

public class TreeNodeHierachy1 {
    public int Level;
    public TreeNode1 Node;
    public UUID Id;
    public UUID ParentId;
    public String RootText;

    public TreeNodeHierachy1(int level, TreeNode1 node, UUID id, UUID parentId, String rootText) {
        Level = level;
        Node = node;
        Id = id;
        ParentId = parentId;
        RootText = rootText;
    }
}

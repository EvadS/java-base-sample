package com.se.sample.demo1;

import java.util.UUID;

public class TreeNodeHierarchy {
    public int Level;
    public TreeNode Node;
    public UUID Id;
    public UUID ParentId;
    public String RootText;

    public TreeNodeHierarchy(int level, TreeNode node, UUID id, UUID parentId, String rootText) {
        Level = level;
        Node = node;
        Id = id;
        ParentId = parentId;
        RootText = rootText;
    }
}

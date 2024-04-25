package org.example;

import java.util.ArrayList;
import java.util.List;

public class FolderDaoModel {
    private Long folderId;          //Current id, Example: 2
    private Long parentId;          //Parent  id, Example: 1
    private String folderName;        // Example: Two
    private FolderDaoModel parent;
    private List<FolderDaoModel> children;    //Example: Folders with IDs 3 & 4
    private String items;   // related referents list joined with comma separator
    public FolderDaoModel() {
        super();
        this.children = new ArrayList<>();
    }

    public FolderDaoModel(String folderName, Long folderId, String items, Long parentId) {
        this.folderName = folderName;
        this.folderId = folderId;
        this.parentId = parentId;
        this.items = items;
        this.children = new ArrayList<>();
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public FolderDaoModel getParent() {
        return parent;
    }

    public void setParent(FolderDaoModel parent) {
        this.parent = parent;
    }

    public List<FolderDaoModel> getChildren() {
        return children;
    }

    public void setChildren(List<FolderDaoModel> children) {
        this.children = children;
    }

    public void addChild(FolderDaoModel child) {
        if (!this.children.contains(child) && child != null)
            this.children.add(child);
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Folder [id=" + folderId + ", parentId=" + parentId + ", value=" + folderName + ", children="
                + children + "]";
    }
}
package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class FolderResponse {
    private String folderName;
    private String items;
    private List<FolderResponse> subFolders;

    public  FolderResponse(){
        this.subFolders = new ArrayList<>();
    }

    public FolderResponse (String folderName, String items) {
        this.folderName = folderName;
        this.items = items;
        this.subFolders = new ArrayList<>();
    }


    public FolderResponse (String folderName, String items, List<FolderResponse>  subFolders) {
        this.folderName = folderName;
        this.items = items;
        this.subFolders = new ArrayList<>();
        this.subFolders.addAll(subFolders);
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public List<FolderResponse> getSubFolders() {
        return subFolders;
    }

    public void setSubFolders(List<FolderResponse> subFolders) {
        this.subFolders = subFolders;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public String toString() {
        return "FolderResponse{" +
                "folderName='" + folderName + '\'' +
                ", items='" + items + '\'' +
                ", subFolders=" + subFolders +
                '}';
    }
}

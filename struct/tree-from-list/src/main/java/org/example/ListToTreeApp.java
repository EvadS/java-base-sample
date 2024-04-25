package org.example;

import org.example.model.FolderResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Tree to be created
 * 1 --> 2
 *       --> 3
 *       --> 4 --> 5
 *
 */
public class ListToTreeApp {

    public static void main(String[] args) {

       FolderDaoModel folderDaoModel1 = new FolderDaoModel("Five", 5L, "10, 20" ,4L);
        FolderDaoModel folderDaoModel2 = new FolderDaoModel("Four", 4L, "10, 20", 2L);
        FolderDaoModel folderDaoModel3 = new FolderDaoModel("Two",  2L, "10, 20", 1L);
        FolderDaoModel folderDaoModel4 = new FolderDaoModel("Three", 3L, "10, 20", 2L);
        FolderDaoModel folderDaoModel5 = new FolderDaoModel("One",   1L, "10, 20", null);

        List<FolderDaoModel> folderDaoModels = new ArrayList<>();
        folderDaoModels.add(folderDaoModel1);
        folderDaoModels.add(folderDaoModel2);
        folderDaoModels.add(folderDaoModel3);
        folderDaoModels.add(folderDaoModel4);
        folderDaoModels.add(folderDaoModel5);

        createTree(folderDaoModels);

    }

    private static void createTree(List<FolderDaoModel> folderDaoModels) {

        Map<Long, FolderDaoModel> mapTmp = new HashMap<>();

        //Save all nodes to a map
        for (FolderDaoModel current : folderDaoModels) {
            mapTmp.put(current.getFolderId(), current);
        }

        //loop and assign parent/child relationships
        for (FolderDaoModel current : folderDaoModels) {
            Long parentId = current.getParentId();

            if (parentId != null) {
                FolderDaoModel parent = mapTmp.get(parentId);
                if (parent != null) {
                    current.setParent(parent);
                    parent.addChild(current);
                    mapTmp.put(parentId, parent);
                    mapTmp.put(current.getFolderId(), current);
                }
            }

        }

        //get the root
        FolderDaoModel root = null;
        for (FolderDaoModel folderDaoModel : mapTmp.values()) {
            if(folderDaoModel.getParent() == null) {
                root = folderDaoModel;
                break;
            }
        }

        System.out.println(root);


       // List<FolderDaoModel> result = flatten(root, null ,new ArrayList<>(), new ArrayList<>());
        FolderResponse convert = convert(root, null);
        int a =0;
    }

    static FolderResponse convert(FolderDaoModel folderDaoModel, FolderResponse root){

        if(folderDaoModel != null) {
            if(root== null){
                root = Mapper.toFolderResponse(folderDaoModel);
            }
            else {
                FolderResponse folderResponse = Mapper.toFolderResponse(folderDaoModel);
                root.getSubFolders().add(folderResponse);

                root = folderResponse;
            }
        }

        List<FolderDaoModel> children = folderDaoModel.getChildren();
        for (FolderDaoModel child : children) {
            if(child.getChildren() != null) {
                convert(child, root);         // Recursive call - Keep flattening until no more children
            }
        }

        return root;
    }



    private static List<FolderDaoModel> flatten(FolderDaoModel folderDaoModel, List<FolderDaoModel> flatList) {

        if(folderDaoModel != null){
            FolderDaoModel n = new FolderDaoModel(folderDaoModel.getFolderName(), folderDaoModel.getFolderId(), folderDaoModel.getItems() , folderDaoModel.getParentId()); // get rid of children & parent references
            flatList.add(n);

            FolderResponse response = Mapper.toFolderResponse(n);
        }

        List<FolderDaoModel> children = folderDaoModel.getChildren();
        for (FolderDaoModel child : children) {
            if(child.getChildren() != null) {
                flattenold(child, flatList);         // Recursive call - Keep flattening until no more children
            }
        }

        // stop or exit condition
        return flatList;
    }



    private static List<FolderDaoModel> flattenold(FolderDaoModel folderDaoModel, List<FolderDaoModel> flatList) {

        if(folderDaoModel != null){
            FolderDaoModel n = new FolderDaoModel(folderDaoModel.getFolderName(), folderDaoModel.getFolderId(), folderDaoModel.getItems() , folderDaoModel.getParentId()); // get rid of children & parent references
            flatList.add(n);
        }

        List<FolderDaoModel> children = folderDaoModel.getChildren();
        for (FolderDaoModel child : children) {
            if(child.getChildren() != null) {
                flattenold(child, flatList);         // Recursive call - Keep flattening until no more children
            }
        }

        // stop or exit condition
        return flatList;
    }
}

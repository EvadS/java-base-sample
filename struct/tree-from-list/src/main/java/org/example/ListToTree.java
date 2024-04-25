package org.example;

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
public class ListToTree {

    public static void main(String[] args) {

        //Create a List of nodes
        FolderDaoModel folderDaoModel5 = new FolderDaoModel("One",   1L,"1,2,3", null);  // root as parentId is null
        FolderDaoModel folderDaoModel1 = new FolderDaoModel("Five", 5L,"1,2,3", 4L);
        FolderDaoModel folderDaoModel2 = new FolderDaoModel("Four", 4L, "1,2,3",2L);
        FolderDaoModel folderDaoModel3 = new FolderDaoModel("Two",  2L, "1,2,3",1L);
        FolderDaoModel folderDaoModel4 = new FolderDaoModel("Three", 3L, "1,2,3",2L);


        List<FolderDaoModel> folderDaoModels = new ArrayList<>();
        folderDaoModels.add(folderDaoModel1);
        folderDaoModels.add(folderDaoModel2);
        folderDaoModels.add(folderDaoModel3);
        folderDaoModels.add(folderDaoModel4);
        folderDaoModels.add(folderDaoModel5);

        //convert to a tree
        FolderDaoModel root = createTree(folderDaoModels);
        System.out.println(root);
    }

    private static FolderDaoModel createTree(List<FolderDaoModel> folderDaoModels) {

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

        return root;
    }
}


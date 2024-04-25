package org.example;

import org.example.model.FolderResponse;

public class Mapper {
    public static FolderResponse toFolderResponse(FolderDaoModel input)
    {
        FolderResponse response = new FolderResponse(
                input.getFolderName(),
                input.getItems()) ;

        return response;
    }
}

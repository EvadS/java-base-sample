package com.se.sample.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.model.Structure;

import java.io.*;
import java.util.List;

public class FileUtils {
    private static final String JSON_EXTENSION = ".json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<String> ReadListFromJson(String resourceFolderLocation, String inputFileName) throws IOException {
        String filepath = resourceFolderLocation + inputFileName;

        try (InputStream is = new FileInputStream(new File(filepath))) {
            return mapper.readValue(is, List.class);
        }
    }

    public static List<Structure> ReadStructureListFromJson(String resourceFolderLocation, String inputFileName) throws IOException {
        String filepath = resourceFolderLocation + inputFileName;

        try (InputStream is = new FileInputStream(new File(filepath))) {
            return mapper.readValue(is, new TypeReference<List<Structure>>() {
            });
        }
    }
}

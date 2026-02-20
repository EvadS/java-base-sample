package com.se.sample.ipsu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDemo {

    public static final String THIRD_JSON_FILE_NAME = "third.json";

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(THIRD_JSON_FILE_NAME);

        String jsonText = readJsonAsString(THIRD_JSON_FILE_NAME);
        List<ReferenceText> list = bindReferenceList(jsonText);


        int a = 0;
    }


    // todo: read json from file
    private static String readByJackson(String fileName) {
        List<ReferenceText> result = new ArrayList<ReferenceText>();

        try (InputStream is = ApplicationDemo.class.getResourceAsStream("/" + fileName)) {

            JsonNode rootNode = objectMapper.readTree(is);
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    // Access elements within the array
                    String name = node.get("documents").asText();

                    JsonNode documents = node.get("documents");
                    for (JsonNode document : documents) {
                        JsonNode referenceNode = document.get("reference");
                        String title = document.get("title").asText();
                        String id = referenceNode.get("id").asText();
                        String an = "";

                        if (referenceNode.has("an")) {
                            an = referenceNode.get("id").asText();
                        }

                        result.add(new ReferenceText(id, title, an));
                        int a = 0;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static String readJsonAsString(String fileName) {
        // Assumes "foo.json" is directly under the "resources" folder

        try (InputStream is = ApplicationDemo.class.getResourceAsStream("/" + fileName)) {
            return objectMapper.readValue(is, String.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static List<ReferenceText> bindReferenceList(String jsonString) throws JsonProcessingException {
        List<ReferenceText> result = new ArrayList<>();

        JsonNode rootNode = objectMapper.readTree(jsonString);
        if (rootNode.isArray()) {
            for (JsonNode node : rootNode) {

                JsonNode documents = node.get("documents");
                for (JsonNode document : documents) {
                    JsonNode referenceNode = document.get("reference");
                    String title = document.get("title").asText();
                    String id = referenceNode.get("id").asText();
                    String an = "";

                    if (referenceNode.has("an")) {
                        an = referenceNode.get("id").asText();
                    }

                    result.add(new ReferenceText(id, title, an));
                }
            }
        }
        return result;
    }
}

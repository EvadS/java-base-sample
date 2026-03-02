package com.se.sample.ipsu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ApplicationDemo {

    public static final String THIRD_JSON_FILE_NAME = "third.json";

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(THIRD_JSON_FILE_NAME);
        List<Object> value = readJsonAsString(THIRD_JSON_FILE_NAME);

        List<ReferenceText> list = bindReferenceList(THIRD_JSON_FILE_NAME);
        List<ReferenceText> list2 = bindReferenceList2(THIRD_JSON_FILE_NAME);


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

    private static List<Object> readJsonAsString(String fileName) {
        // Assumes "foo.json" is directly under the "resources" folder

        try (InputStream is = ApplicationDemo.class.getResourceAsStream("/" + fileName)) {
            return objectMapper.readValue(is, new TypeReference<List<Object>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public static List<ReferenceText> bindReferenceList(String fileName)   {
        List<ReferenceText> result = new ArrayList<>();

        try (InputStream is= ApplicationDemo.class.getResourceAsStream("/" + fileName)){

            JsonNode rootNode = objectMapper.readTree(is);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public static List<ReferenceText> bindReferenceList2(String jsonString)   {
        List<ReferenceText> result = new ArrayList<>();
        // ----------------------------------------------------------------------------------------------

        try (InputStream is = ApplicationDemo.class.getResourceAsStream("/" + THIRD_JSON_FILE_NAME)) {


            JsonNode rootNode2 = objectMapper.readTree(is);
            JsonNode contacts = rootNode2.path("documents");


            List<JsonNode> documents = StreamSupport.stream(rootNode2.spliterator(), false)
                    .map(i -> i.get("documents"))
                    .collect(Collectors.toList());

            List<ReferenceText> documents1 = StreamSupport.stream(rootNode2.spliterator(), false)
                    .flatMap(i -> StreamSupport.stream(i.get("documents").spliterator(), false)
                            .map(j -> bindReference(j)))
                    .collect(Collectors.toList());

            // here
            List<JsonNode> jsonDocuments = StreamSupport.stream(rootNode2.spliterator(), false)
                    .flatMap(i -> StreamSupport.stream(i.get("documents").spliterator(), false)
                            .map(j -> bindJonNode(j)))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


              return result;
    }

    private static ReferenceText bindReference(JsonNode jsonNode) {

        String title = jsonNode.get("title").asText();

        JsonNode referenceNode = jsonNode.get("reference");
        String id = referenceNode.get("id").asText();
        String an = "";

        if (referenceNode.has("an")) {
            an = referenceNode.get("id").asText();
        }

        return new ReferenceText(id, an, title);
    }


    private static JsonNode bindJonNode(JsonNode rootNode) {

        Set<String> targetFields = new HashSet<>();

        // Extract required fields
        // String id = rootNode.path("id").asText();
        JsonNode reference = rootNode.path("reference");
        JsonNode title = rootNode.path("title");
        String id = reference.get("id").asText();
        String an = "";
        if(reference.has("an")){
            an = reference.get("an").asText();
        }

        // Create a new JsonNode for the transformed request
        ObjectNode transformedRequest = objectMapper.createObjectNode();
        transformedRequest.put("id", id);
        transformedRequest.put("an", an);
        transformedRequest.put("title", title);

        return transformedRequest;
    }


}

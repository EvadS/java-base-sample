package com.se.sample.providers.jackson;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * JsonNode is a class provided by the Jackson library that represents a node in a JSON tree structure.
 * It is part of Jackson's Tree Model, which allows for parsing, manipulating, and generating JSON content
 * in a hierarchical tree form. This is useful for working with JSON data in a more flexible and dynamic
 * way compared to direct data binding to Java objects.
 */
public class JsonNodeExample {
    public static void main(String[] args) {
        createFromString();
    }

    private static void createFromString() {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"address\":{\"street\":\"123 Main St\",\"city\":\"Anytown\"}}";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse JSON string into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // Accessing fields
            String name = rootNode.path("name").asText();
            int age = rootNode.path("age").asInt();
            String street = rootNode.path("address").path("street").asText();
            String city = rootNode.path("address").path("city").asText();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Street: " + street);
            System.out.println("City: " + city);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void  transformationCode(){
        String incomingRequest = "{\"user\":{\"name\":\"Jane Doe\",\"contact\":{\"email\":\"jane.doe@example.com\",\"phone\":\"123-456-7890\"}},\"transaction\":{\"id\":\"abc123\",\"amount\":250.75}}";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse incoming request into a JsonNode
            JsonNode rootNode = objectMapper.readTree(incomingRequest);

            // Extract required fields
            String fullName = rootNode.path("user").path("name").asText();
            String email = rootNode.path("user").path("contact").path("email").asText();
            String transactionId = rootNode.path("transaction").path("id").asText();
            double amount = rootNode.path("transaction").path("amount").asDouble();

            // Create a new JsonNode for the transformed request
            ObjectNode transformedRequest = objectMapper.createObjectNode();
            transformedRequest.put("fullName", fullName);
            transformedRequest.put("email", email);
            transformedRequest.put("transactionId", transactionId);
            transformedRequest.put("amount", amount);

            // Convert the transformed JsonNode to a JSON string
            String transformedJsonString = objectMapper.writeValueAsString(transformedRequest);

            // Output the transformed JSON
            System.out.println("Transformed JSON: " + transformedJsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

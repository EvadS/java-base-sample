package com.se.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws JsonProcessingException {

        baseParsingDemo();

        getJonNodeFieldsValueDemo();
        System.out.println("------------------------------------");

        getJsonNodeFieldAtPath();
        System.out.println("------------------------------------");

        createJsonNode();
        System.out.println("------------------------------------");

    }

    private static void createJsonNode() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
       // JsonNode node = JsonNodeFactory.instance.objectNode();





    }

    private static void convertJsonNodeField() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{ \"f1\":\"Hello\", \"f2\":null }";

        JsonNode jsonNode = objectMapper.readTree(json);

        // asDouble(), asInt() and asLong()
        String f2Value = jsonNode.get("f2").asText("Default");
        System.out.println("f2Value: " + f2Value);

        //step 2  if the field is not explicitly set to null in
        jsonNode = objectMapper.readTree(json);
        JsonNode f2FieldNode = jsonNode.get("f2");
        System.out.println("f2FieldNode: " + f2FieldNode);

        // handle null value

        System.out.println("Handle null value");
        json = "{ \"f1\":\"Hello\", \"f2\":null }";

        jsonNode = objectMapper.readTree(json);

        f2FieldNode = jsonNode.get("f2");
        System.out.println("f2FieldNode: " + f2FieldNode);

        boolean isFieldValueNull = f2FieldNode.isNull();
        System.out.println("check nullable f2FieldNode: " + isFieldValueNull);

        System.out.println("-- handle nullable");
        JsonNode fieldNode = jsonNode.get("fieldName");

        if (fieldNode == null || fieldNode.isNull()) {
            System.out.println("fieldNode is null");
            // the field is either not present in parentNode, or explicitly set to null .
        }
        else{
            System.out.println("field is present");
        }
    }


    private static void getJsonNodeFieldAtPath() throws JsonProcessingException {
        String json =
                "{\n" +
                        "  \"identification\" :  {\n" +
                        "        \"name\" : \"James\",\n" +
                        "        \"ssn\"  : \"ABC123552\"\n" +
                        "    }\n" +
                        "}";
        //parse
        JsonNode jsonNode = parseStringToJsonNode(json); //parse above JSON into a JsonNode

        JsonNode nameNode = jsonNode.at("/identification/name");
        System.out.println("nameNode: " + nameNode);
    }

    /**
     * get value from json fields
     *
     * @throws JsonProcessingException
     */
    private static void getJonNodeFieldsValueDemo() throws JsonProcessingException {
        String json =
                "{\n" +
                        "    \"field1\" : \"value1\",\n" +
                        "    \"field2\" : 999\n" +
                        "}";

        //parse
        JsonNode jsonNode = parseStringToJsonNode(json); //parse above JSON into a JsonNode

        //  obtain the two fields
        JsonNode field1 = jsonNode.get("field1");
        JsonNode field2 = jsonNode.get("field2");

        System.out.println("field1: " + field1);
        System.out.println("field2: " + field2);
    }


    private static void baseParsingDemo() throws JsonProcessingException {
        String json = "{ \"f1\" : \"v1\" } ";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(json);

        System.out.println(jsonNode.get("f1").asText());
    }

    private static JsonNode parseStringToJsonNode(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode;
    }

}

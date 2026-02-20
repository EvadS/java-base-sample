package com.se.sample.providers.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.StringWriter;

public class JacksonApplication {

    public static void main(String[] args) {
        readPersonFromString();
        readEmployeeFromString();
        treeModel();

        streamingData();
    }

    private static void streamingData() {
        String jsonString = "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"age\": 30, \"address\": {\"street\": \"123 Main St\", \"city\": \"Anytown\", \"state\": \"CA\"}}";

        try {
            // Read JSON data using streaming model
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(jsonString);

            while (!jsonParser.isClosed()) {
                JsonToken token = jsonParser.nextToken();

                if (JsonToken.FIELD_NAME.equals(token)) {
                    String fieldName = jsonParser.getCurrentName();
                    System.out.println("Field: " + fieldName);
                } else if (JsonToken.VALUE_STRING.equals(token)) {
                    String value = jsonParser.getValueAsString();
                    System.out.println("Value: " + value);
                } else if (JsonToken.VALUE_NUMBER_INT.equals(token)) {
                    int value = jsonParser.getValueAsInt();
                    System.out.println("Value: " + value);
                }
            }

            jsonParser.close();

            // Write JSON data using streaming model
            StringWriter stringWriter = new StringWriter();
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(stringWriter);

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("firstName", "Jane");
            jsonGenerator.writeStringField("lastName", "Doe");
            jsonGenerator.writeNumberField("age", 28);
            jsonGenerator.writeObjectFieldStart("address");
            jsonGenerator.writeStringField("street", "456 Elm St");
            jsonGenerator.writeStringField("city", "Othertown");
            jsonGenerator.writeStringField("state", "NY");
            jsonGenerator.writeEndObject();
            jsonGenerator.writeEndObject();

            jsonGenerator.close();

            String generatedJsonString = stringWriter.toString();
            System.out.println("Generated JSON: " + generatedJsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * В этом примере мы продемонстрируем, как использовать потоковую модель библиотеки FasterXML Jackson
     * для чтения и записи данных JSON в потоковом режиме. Мы начнем со строки JSON и будем использовать потоковую
     * модель для чтения данных JSON, а затем используем потоковую модель для записи данных JSON. Мы также
     * можем читать данные из входного потока вместо чтения из предопределенной строки, но для простоты мы
     * будем читать их непосредственно из строки.
     */
    private static void treeModel() {
        String jsonString = "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"age\": 30, \"address\": {\"street\": \"123 Main St\", \"city\": \"Anytown\", \"state\": \"CA\"}}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // Modify the age property
            JsonNode ageNode = rootNode.path("age");
            System.out.println("Age: " + ageNode.asInt());

            ((ObjectNode) rootNode).put("age", 35);
            System.out.println("Updated age: " + rootNode.path("age").asInt());

            // Add a new property to the address object
            JsonNode addressNode = rootNode.path("address");
            ((ObjectNode) addressNode).put("country", "USA");
            System.out.println("Updated address: " + rootNode.path("address").toString());

            // Remove the state property from the address object
            ((ObjectNode) addressNode).remove("state");
            System.out.println("Address without state: " + rootNode.path("address").toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void readEmployeeFromString() {

        ObjectMapper objectMapper = new ObjectMapper();

        // Create an Employee object
        Employee employee = new Employee("E001", "Jane", "Doe", "jane.doe@example.com", 50000);

        try {
            // Serialize the Employee object to JSON
            String jsonString = objectMapper.writeValueAsString(employee);
            System.out.println("Serialized JSON: " + jsonString);

            // Deserialize the JSON back to an Employee object
            Employee deserializedEmployee = objectMapper.readValue(jsonString, Employee.class);
            System.out.println("Deserialized Employee: " + deserializedEmployee.getEmployeeId() + ", " + deserializedEmployee.getFirstName() + " " + deserializedEmployee.getLastName() + ", salary: " + deserializedEmployee.getSalary());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readPersonFromString() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a Person object
        Person person = new Person("John", "Doe", 30);

        try {
            // Serialize the Person object to JSON
            String jsonString = objectMapper.writeValueAsString(person);
            System.out.println("Serialized JSON: " + jsonString);

            // Deserialize the JSON back to a Person object
            Person deserializedPerson = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Deserialized Person: " + deserializedPerson.getFirstName() + " " + deserializedPerson.getLastName() + ", age " + deserializedPerson.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

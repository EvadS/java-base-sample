package com.se.sample.serializer;

import java.io.IOException;
import java.time.LocalDate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFormatterExample {

   private static  ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public static void main(String[] args) throws IOException {
        // Create a sample Person object
        Person person = new Person("John Doe", LocalDate.of(2000, 5, 15));

        // Serialize the Person object to JSON
        String json = objectMapper.writeValueAsString(person);
        System.out.println("Serialized JSON: " + json);

        // Deserialize the JSON back to Person object
        Person deserializedPerson = objectMapper.readValue(json, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson.getName() + ", " + deserializedPerson.getBirthDate());
    }
}

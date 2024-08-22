package org.example.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {


    @Test
    public void addressTest() throws JsonProcessingException {
        Address address =
                Address.builder()
                        .street("street")
                        .zipCode("1234")
                        .city("my city")
                        .province("province")
                        .country("country")
                        .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(address);
        System.out.println("---------------------------------------------");
        System.out.println(json);
        System.out.println("---------------------------------------------");

        Address read = objectMapper.readValue(json, Address.class);
        assertEquals(address, read);
    }
}
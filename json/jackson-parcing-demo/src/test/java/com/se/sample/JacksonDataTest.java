package com.se.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.se.sample.model.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonDataTest {
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Test
    void orderToJson() throws JsonProcessingException {
        Order order = new Order(1, LocalDate.of(1900,2,1));

        String json = objectMapper.writeValueAsString(order);

        System.out.println(json);
    }

    @Test
    void orderToJsonWithDate() throws JsonProcessingException {
        Order order = new Order(1, LocalDate.of(2023, 1, 1));

        String json = objectMapper.writeValueAsString(order);

        System.out.println(json);
    }

    @Test
    void fileToOrder() throws IOException {
        File file = new File("src/test/resources/order.json");

        Order order = objectMapper.readValue(file, Order.class);

        assertThat(order.getDate().getYear()).isEqualTo(2000);
        assertThat(order.getDate().getMonthValue()).isEqualTo(4);
        assertThat(order.getDate().getDayOfMonth()).isEqualTo(30);
    }
}

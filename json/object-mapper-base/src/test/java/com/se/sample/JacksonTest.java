package com.se.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.model.Employee;
import com.se.sample.model.Order;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class JacksonTest {

    ObjectMapper objectMapper = new ObjectMapper();

    ObjectMapper objectMapper2 = new ObjectMapper().findAndRegisterModules();

    @Test
    public void pojoToJsonString() throws JsonProcessingException {
        Employee employee = new Employee("Mark", "James", 20);

        String json = objectMapper.writeValueAsString(employee);
        System.out.println(json);
    }

    @Test
    public void jsonStringToPojo() throws JsonProcessingException {
        String employeeJson = "{\n" +
                " \"firstName\" : \"Jalil\",\n" +
                " \"lastName\" : \"Jarjanazy\",\n" +
                " \"age\" : 30\n" +
                "}";

        Employee employee = objectMapper.readValue(employeeJson, Employee.class);

        Assert.assertEquals(employee.getFirstName(), "Jalil");
        Assert.assertEquals(employee.getLastName(), "Jarjanazy");
    }

    @Test
    public void jsonFileToPojo() throws IOException {
        File file = new File("src/test/resources/employee.json");

        Employee employee = objectMapper.readValue(file, Employee.class);

        Assert.assertEquals((employee.getAge()), 44);
        Assert.assertEquals((employee.getLastName()), "Simpson");
        Assert.assertEquals((employee.getFirstName()), "Homer");
    }

    @Test
    public void fileToListOfPojos() throws IOException {
        File file = new File("src/test/resources/employeeList.json");
        List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<List<Employee>>() {
        });

        Assert.assertEquals(employeeList.size(), 2);
        Assert.assertEquals(employeeList.get(0).getAge(), 33);
        Assert.assertEquals(employeeList.get(0).getLastName(), "Simpson");
        Assert.assertEquals(employeeList.get(0).getFirstName(), "Marge");
    }

    @Test
    public void fileToMap() throws IOException {
        File file = new File("src/test/resources/employee.json");
        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {
        });

        Assert.assertTrue(employee.containsKey("firstName"));//, "lastName", "age");

        Assert.assertEquals(employee.get("firstName"), "Homer");
        Assert.assertEquals(employee.get("lastName"), "Simpson");
        Assert.assertEquals(employee.get("age"), 44);
    }

    @Test
    public void fileToMap2() throws IOException {
        // если мы не знаем, чего ожидать от файла JSON, который мы пытаемся спарсить
        File file = new File("src/test/resources/employee.json");
        //имя каждой переменной в JSON в ключ для Map, а значение этой переменной — в значение по этому ключу.
        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<Map>() {
        });

        Assert.assertTrue(employee.containsKey("firstName"));//, "lastName", "age");

        Assert.assertEquals(employee.get("firstName"), "Homer");
        Assert.assertEquals(employee.get("lastName"), "Simpson");
        Assert.assertEquals(employee.get("age"), 44);
    }


    @Test
    public void fileToMap3() throws IOException {
        File file = new File("src/test/resources/employeeWithUnknownProperties.json");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<Map>() {
        });

        Assert.assertTrue(employee.containsKey("firstName"));
        Assert.assertTrue(employee.containsKey("lastName"));
        Assert.assertTrue(employee.containsKey("age"));

        Assert.assertEquals(employee.get("firstName"), "Homer");
        Assert.assertEquals(employee.get("lastName"), "Simpson");
        Assert.assertEquals(employee.get("age"), 44);
    }


    @Test
    public void orderToJson() throws JsonProcessingException {
        Order order = new Order(1, LocalDate.of(1900, 2, 1));

        String json = objectMapper2.writeValueAsString(order);

        System.out.println(json);
    }

    @Test
    public  void fileToOrder() throws IOException {
        File file = new File("src/test/resources/order.json");

        Order order = objectMapper.readValue(file, Order.class);

        Assert.assertEquals(order.getDate().getYear(),2000);
        Assert.assertEquals(order.getDate().getMonthValue(),4);
        Assert.assertEquals(order.getDate().getDayOfMonth(),30);
    }
}


package com.se.sample.gson;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import com.se.sample.ParameterizedTypeImpl;
import com.se.sample.models.School;
import com.se.sample.models.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonArrayStringToListUnitTest {

    Logger LOGGER = LoggerFactory.getLogger(JsonArrayStringToListUnitTest.class);
    final String jsonArrayOfStudents =
            "["
                    + "{\"name\":\"John\", \"grade\":\"1\"}, "
                    + "{\"name\":\"Tom\", \"grade\":\"2\"}, "
                    + "{\"name\":\"Ram\", \"grade\":\"3\"}, "
                    + "{\"name\":\"Sara\", \"grade\":\"1\"}"
                    + "]";
    final String jsonArrayOfSchools =
            "["
                    + "{\"name\":\"St. John\", \"city\":\"Chicago City\"}, "
                    + "{\"name\":\"St. Tom\", \"city\":\"New York City\"}, "
                    + "{\"name\":\"St. Ram\", \"city\":\"Mumbai\"}, "
                    + "{\"name\":\"St. Sara\", \"city\":\"Budapest\"}"
                    + "]";

    @Test
    void givenJsonArray_whenListElementTypeDynamic_thenConvertToJavaListUsingTypeToken() {
        Gson gson = new Gson();
        TypeToken<List<Student>> typeTokenForListOfStudents = new TypeToken<List<Student>>() {
        };
        TypeToken<List<School>> typeTokenForListOfSchools = new TypeToken<List<School>>() {
        };


        List<Student> studentsLst = gson.fromJson(jsonArrayOfStudents, typeTokenForListOfStudents.getType());
        List<School> schoolLst = gson.fromJson(jsonArrayOfSchools, typeTokenForListOfSchools.getType());
        assertAll(
                () -> studentsLst.forEach(e -> assertTrue(e instanceof Student)),
                () -> schoolLst.forEach(e -> assertTrue(e instanceof School))
        );
    }

    @Test
    void givenJsonArray_whenListElementTypeDynamic_thenConvertToJavaListUsingParameterizedType() {
        Gson gson = new Gson();
        List<Student> studentsLst = gson.fromJson(jsonArrayOfStudents, ParameterizedTypeImpl.make(List.class, Student.class));
        List<School> schoolLst = gson.fromJson(jsonArrayOfSchools, ParameterizedTypeImpl.make(List.class, School.class));
        assertAll(
                () -> studentsLst.forEach(e -> assertTrue(e instanceof Student)),
                () -> schoolLst.forEach(e -> assertTrue(e instanceof School))
        );
    }
}

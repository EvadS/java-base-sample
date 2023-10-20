package com.se.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MapperTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public  void toStringAndBack () throws JsonProcessingException {

        List<String> list = Arrays.asList("", "", "");
        String jsonArray = mapper.writeValueAsString(list);

        List<String> asList = mapper.readValue(jsonArray, List.class);
        assertThat((Object) asList.get(0), instanceOf(List.class));

    }
}

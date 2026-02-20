package com.se.sample.jsontomap;


import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;





public class FlattenUtilsTest {
    @Test
    void givenTwoJsonFiles_whenCompared_thenTheyAreDifferent() throws IOException {
        Map<String, Object> firstMap = JsonUtils.jsonFileToMap("src/test/resources/first.json");
        Map<String, Object> secondMap = JsonUtils.jsonFileToMap("src/test/resources/second.json");

        MapDifference<String, Object> difference = Maps.difference(firstMap, secondMap);
        difference.entriesDiffering().forEach((key, value) -> {
            System.out.println(key + ": " + value.leftValue() + " - " + value.rightValue());
        });

        int a =0;
      //  assertThat(difference.areEqual()).isFalse();
    }

    @Test
    void givenTwoJsonFiles_whenFlattenedAndCompared_thenTheyAreDifferent() throws IOException {
        Map<String, Object> firstFlatMap = FlattenUtils.flatten(JsonUtils.jsonFileToMap("src/test/resources/first.json"));
        Map<String, Object> secondFlatMap = FlattenUtils.flatten(JsonUtils.jsonFileToMap("src/test/resources/second.json"));

        MapDifference<String, Object> difference = Maps.difference(firstFlatMap, secondFlatMap);
        difference.entriesDiffering().forEach((key, value) -> {
            System.out.println(key + ": " + value.leftValue() + " - " + value.rightValue());
        });
        int a =0;
        // assertThat(difference.areEqual()).isFalse();
    }


    }
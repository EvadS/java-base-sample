package com.se.sample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Deprecated
public class GroupByMapExample {
    public static void main(String[] args) {
        // Sample data
        List<Map<String, Object>> data = Arrays.asList(
                Map.of("id", 1, "type", "A", "value", 10),
                Map.of("id", 2, "type", "B", "value", 20),
                Map.of("id", 3, "type", "A", "value", 30),
                Map.of("id", 4, "type", "B", "value", 40)
        );

        // Group the data by the "type" key
        Map<Object, List<Map<String, Object>>> groupedByType = data.stream()
                .collect(Collectors.groupingBy(map -> map.get("type")));

        // Print the result
        System.out.println(groupedByType);
    }
}

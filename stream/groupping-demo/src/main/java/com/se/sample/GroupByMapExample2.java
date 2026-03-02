package com.se.sample;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class GroupByMapExample2 {
    private static List<String> fieldsToKeep = Arrays.asList("name", "uid");

    public static void main(String[] args) {

        // Sample data
        List<Map<String, Object>> data = Arrays.asList(
                Map.of("id", 5, "uid", 6),
                Map.of("id", 5, "uid", 7),
                Map.of("id", 6, "uid", 8),
                Map.of("id", 7, "uid", 7),
                Map.of("id", 8, "uid", 7),
                Map.of("id", 8, "uid", 9)
        );

        Map<Integer, List<Integer>> item =  grouppingDemo(data);



        List<Map<String, Object>> list = Arrays.asList(
                Map.of("id", 5, "uid", 16, "name", "name1", "val", 1),
                Map.of("id", 5, "uid", 17, "name", "name2", "val", 2),
                Map.of("id", 6, "uid", 18, "name", "name3", "val", 3),
                Map.of("id", 7, "uid", 17, "name", "name4", "val", 4),
                Map.of("id", 8, "uid", 17, "name", "name5", "val", 5),
                Map.of("id", 8, "uid", 19, "name", "name6", "val", 6)
        );

        grouppingDemo2(list);
    }

    //Collectors.groupingBy with a downstream collector like Collectors.mapping
    static  Map<Integer, List<Integer>> grouppingDemo(List<Map<String, Object>> input) {
        return input.stream()
                .collect(Collectors.groupingBy(
                        m -> (Integer) (m.get("id")),
                        Collectors.mapping(m -> (Integer) m.get("uid"), /*downstream*/
                                Collectors.toList())));
    }

    static void grouppingDemo2(List<Map<String, Object>> input) {
        Map<Integer, List<Object>> id = input.stream()
                .collect(Collectors.groupingBy(
                        m -> (Integer) (m.get("id")),
                        Collectors.mapping(GroupByMapExample2::mapFields, /*downstream*/
                                Collectors.toList())));

        Map<Integer, List<Map<String, Object>>> id1 = input.stream()
                .collect(Collectors.groupingBy(
                        i -> (Integer) (i.get("id")),
                        Collectors.mapping(m -> m.entrySet().stream()
                                        .filter(entry -> fieldsToKeep.contains(entry.getKey()))
                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)), /*downstream*/
                                Collectors.toList())));


        int a = 0;
    }

    private static Map<String, Object> mapFields(Map<String, Object> m) {
        return m.entrySet().stream()
                .filter(entry -> fieldsToKeep.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

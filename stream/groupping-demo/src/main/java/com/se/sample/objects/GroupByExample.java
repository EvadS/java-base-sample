package com.se.sample.objects;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        demo1();
        
        demo2();
    }

    private static void demo2() {



int a =0;
    }

    private static void demo1() {
        // Sample data: A LinkedList of Maps
        LinkedList<Map<String, Object>> dataList = new LinkedList<>(Arrays.asList(
                Map.of("id", 1, "type", "A", "value", 100),
                Map.of("id", 2, "type", "B", "value", 200),
                Map.of("id", 3, "type", "A", "value", 150),
                Map.of("id", 4, "type", "B", "value", 250),
                Map.of("id", 5, "type", "C", "value", 300)
        ));

        // Grouping the list of maps by the value of the "type" key
        Map<String, List<Map<String, Object>>> groupedByType = dataList.stream()
                .collect(Collectors.groupingBy(
                        map -> (String) map.get("type") // Classifier function: gets the value of the "type" key
                ));

        // Print the result
        System.out.println(groupedByType);
        // Expected output:
        // {A=[{value=100, type=A, id=1}, {value=150, type=A, id=3}],
        //  B=[{value=200, type=B, id=2}, {value=250, type=B, id=4}],
        //  C=[{value=300, type=C, id=5}]}
    }
}

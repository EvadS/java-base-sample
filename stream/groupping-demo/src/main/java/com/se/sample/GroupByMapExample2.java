package com.se.sample;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByMapExample2 {



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


         grouppingDemo(data);


        List<Map<String, ? extends Serializable>> list = Arrays.asList(
                Map.of("id", 5, "uid", 6, "name", "name"),
                Map.of("id", 5, "uid", 7, "name", "name"),
                Map.of("id", 6, "uid", 8, "name", "name"),
                Map.of("id", 7, "uid", 7, "name", "name"),
                Map.of("id", 8, "uid", 7, "name", "name"),
                Map.of("id", 8, "uid", 9, "name", "name")
        );


    }

    //Collectors.groupingBy with a downstream collector like Collectors.mapping
   static void grouppingDemo(List<Map<String, Object>> input){
       Map<Integer, List<Integer>> result = input.stream()
               .collect(Collectors.groupingBy(
                       m -> (Integer) (m.get("id")),
                       Collectors.mapping(m -> (Integer) m.get("uid"), /*downstream*/
                               Collectors.toList())));

       int a =0;
    }
}

package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestGroupped {

    public static void main(String[] args) {

//        List<String> rows = new ArrayList<>();
//        rows.add("323-050");
//        rows.add("323-050.130");
//        rows.add("323-050.130.020");
//
//        rows.add("323-060");
//        rows.add("323-060.070");
//        rows.add("323-060.070.170");

        List<String> rows = Arrays.asList(
        "323-060",
                "323-060.040",
                "323-060.040.030",

                "323-060.088",
                "323-060.088.020"
        );

        String result = Arrays.stream("323-050,323-050.130,323-050.130.020".split(","))
                //.filter(role -> role.contains("UC"))
                .map(String::trim).collect(Collectors.joining(","));


        Map<String, List<String>> collect = rows.stream()
                .collect(Collectors.groupingBy(i -> i.split(",")[0]));


        Map<Boolean, List<String>> collect1 = rows.stream()
                .collect(Collectors.partitioningBy(a -> a.startsWith("323-060")));

        Map<String, List<String>> collect2 = rows.stream()
                .collect(Collectors.groupingBy(a -> a.split("\\.")[0]));


        Map<String, List<String>> collect3 = rows.stream()
                .collect(Collectors.groupingBy(a -> a.split("\\.")[0], Collectors.toList()));


        List<String> collect4 = rows.stream()
                .collect(Collectors.groupingBy(a -> a.split("\\.")[0]))
                .values()
                .stream()
                .map(i -> i.stream().collect(Collectors.joining("\\")))
                .collect(Collectors.toList());

        int b =0;
    }
}
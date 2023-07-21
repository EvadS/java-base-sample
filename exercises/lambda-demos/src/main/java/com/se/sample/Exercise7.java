package com.se.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 *  Java program to implement a lambda expression to remove duplicates from a list of integers
 */
public class Exercise7 {
    public static void main(String[] args) {
        // Create a list of strings
        List<Integer> nums = Arrays.asList(1,1,2,3,4,4,4,5,5,6,7,8,9,9);
        System.out.println("Original values: " + nums);

        // Duplicate processing of the list using lambda expression
        List<Integer> result = nums.stream()
                .mapToInt(Integer::intValue).distinct()
                .mapToObj(o -> o)
                .collect(Collectors.toList());

        // Print the average
        System.out.println("Result values: " + result);
    }
}

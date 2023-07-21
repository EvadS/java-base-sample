package com.se.sample;

import java.util.Arrays;
import java.util.List;

/**
 * Java program to implement a lambda expression to find the average of a list of doubles.
 */
public class Exercise6 {
    public static void main(String[] args) {



        // Create a list of strings
        List<Double> nums = Arrays.asList(1.0,2.9,6.0,85.0,4.0);
        System.out.println("Original values: " + nums);

        // Calculate the average of the list using lambda expression
        double average = nums.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        // Print the average
        System.out.println("\nAverage of the original values: " + average);
    }
}

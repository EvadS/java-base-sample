package com.se.sample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Java program to create a lambda expression to multiply and sum all elements in a list of integers.
 */
public class Exercise12 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> nums = Arrays.asList(12, 15, 0, 8, 7, 9, -6);
        System.out.println("Original values of the said array: "+nums);


        // multiply elements using lambda expression
        Integer multiplied = nums.stream().reduce(1, (a, b) -> a * b).intValue();
        Integer sum = nums.stream().reduce(0, (a, b) -> a+b);
        Integer sum2 = nums.stream().mapToInt(a -> a).sum();


        // Print the maximum and minimum values
        System.out.println("Multiplied value : " + multiplied);
        System.out.println("Summed value : " + sum);
    }
}

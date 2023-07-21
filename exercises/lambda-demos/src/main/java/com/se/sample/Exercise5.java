package com.se.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> colors = Arrays.asList("red", "green", "blue", "black", "pink");

        // Print the Original list of strings
        System.out.println("Original strings:");
        for (String str : colors) {
            System.out.print(str + ' ');
        }

        // Sort the list of strings in alphabetical order using lambda expression
        colors.sort((str1, str2) -> str1.compareToIgnoreCase(str2));

        // Print the sorted list of strings
        System.out.println("\nSorted strings:");
        for (String str : colors) {
            System.out.print(str + ' ');
        }
    }
}

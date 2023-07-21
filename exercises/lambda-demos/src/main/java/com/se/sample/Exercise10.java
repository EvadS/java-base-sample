package com.se.sample;

import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 *  Java program to implement a lambda expression to concatenate two strings.
 */
public class Exercise10 {
    public static void main(String[] args) {

        // Define the concatenate lambda expression
        BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + str2;

        // Concatenate two strings using the lambda expression
        String string1 = "Good ";
        String string2 = "Morning!";
        System.out.println("Original strings: " + string1 + ", " +string2);
        String result = concatenate.apply(string1, string2);

        // Print the concatenated string
        System.out.println("\nConcatenated string: " + result);

        System.out.println("===============================");
        BiFunction<Integer, Integer, Integer> res  = (o1,o2) -> o1* o2;
        System.out.println("Res: "+ res.apply(10, 2));
    }
}


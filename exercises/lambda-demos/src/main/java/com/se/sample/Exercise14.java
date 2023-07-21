package com.se.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Java program to implement a lambda expression to check if a given string is a palindrome.
 */
public class Exercise14 {
    public static void main(String[] args) {

        String sentence = "program to implement a lambda expression to count words in a sentence";

        // Define the palindrome check lambda expression
        Predicate< String > isPalindrome = str -> {
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed);
        };

        // Check if a string is a palindrome using the lambda expression
        String word1 = "Madam";
        boolean isPalindromeResult1 = isPalindrome.test(word1);
        System.out.println(word1 + " is a palindrome? " + isPalindromeResult1);

        String word2 = "radar";
        isPalindromeResult1 = isPalindrome.test(word2);
        System.out.println(word2 + " is a palindrome? " + isPalindromeResult1);

        String word3 = "defied";
        isPalindromeResult1 = isPalindrome.test(word3);
        System.out.println(word3 + " is a palindrome? " + isPalindromeResult1);


        List< Integer > nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original list elements: " + nums);
        // Calculate the sum of squares of odd numbers using lambda expression

        nums.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(n -> n * n)
                .toArray();

        // .sum();

        int a =0;
    }
}

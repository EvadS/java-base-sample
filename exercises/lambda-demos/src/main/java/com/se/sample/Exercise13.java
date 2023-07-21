package com.se.sample;

import java.util.Arrays;
import java.util.List;

/**
 * Java program to implement a lambda expression to count words in a sentence.
 */
public class Exercise13 {
    public static void main(String[] args) {

        String sentence = "program to implement a lambda expression to count words in a sentence";

        WordCounter wordCounter = s -> s.split("\\s+").length;
        int ctr = wordCounter.countWords(sentence);

        System.out.println("Word count: " + ctr);
    }

    @FunctionalInterface
    interface WordCounter {
        int countWords(String text);
    }
}

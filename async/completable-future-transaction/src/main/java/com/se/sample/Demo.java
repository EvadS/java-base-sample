package com.se.sample;

import com.se.sample.model.Transaction;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        var categories = Stream.of(
                        new Transaction("1", "description 1"),
                        new Transaction("2", "description 2"),
                        new Transaction("3", "description 3"),
                        new Transaction("4", "description 4"),
                        new Transaction("5", "description 5"),
                        new Transaction("6", "description 6"),
                        new Transaction("7", "description 7"),
                        new Transaction("8", "description 8"),
                        new Transaction("9", "description 9")
                )
                .map(CategorizationService::categorizeTransaction)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();

        System.out.printf("The operation took %s ms%n", end - start);
        System.out.println("Categories are: " + categories);
    }
}

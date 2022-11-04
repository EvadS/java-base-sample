package com.se.sample;

import com.se.sample.model.Transaction;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DemoCompletableFuture {


    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();

        var futureCategories = Stream.of(
                        new Transaction("1", "description 1"),
                        new Transaction("2", "description 2"),
                        new Transaction("3", "description 3"),
                        new Transaction("4", "description 4"),
                        new Transaction("5", "description 5"),
                        new Transaction("6", "description 6"),
                        new Transaction("7", "description 7"),
                        new Transaction("8", "description 8"),
                        new Transaction("9", "description 9"),
                        new Transaction("10", "description 10")
                )
                .map(transaction -> CompletableFuture.supplyAsync(
                        () -> CategorizationService.categorizeTransaction(transaction)
                        , executor)
                )
                .collect(toList());

        var categories = futureCategories.stream()
                .map(CompletableFuture::join)
                .collect(toList());
        long end = System.currentTimeMillis();

        System.out.printf("The operation took %s ms%n", end - start);
        System.out.println("Categories are: " + categories);
    }
}

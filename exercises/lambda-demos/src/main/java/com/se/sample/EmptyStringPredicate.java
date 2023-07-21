package com.se.sample;

import java.util.function.Predicate;

/**
 * a Java program to implement a lambda expression to check if a given string is empty.
 */
public class EmptyStringPredicate {


    public static void main(String[] args) {

        // Lambda expression to check if a given string is empty
        /**
         * Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия. Если оно соблюдается,
         * то возвращается значение true. В качестве параметра лямбда-выражение принимает объект типа T:
         */
        Predicate<String> isEmptyString = str -> str.isEmpty();

        // Test cases
        String str1 = ""; // empty string
        String str2 = "Java lambda expression!"; // non-empty string

        // Check if the strings are empty using the lambda expression
        System.out.println("String 1:" + str1);
        System.out.println("String 1 is empty: " + isEmptyString.test(str1));
        System.out.println("\nString 2:" + str2);
        System.out.println("String 2 is empty: " + isEmptyString.test(str2));

    }

}

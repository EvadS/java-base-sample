package com.se.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {

        Predicate<String> pr1 = s-> s.startsWith("J");
        Predicate<String> pr2 = s-> s.startsWith("N");
        Predicate<String> pr3 = s-> s.endsWith("A");

        Predicate<String> resPredicate = pr1.or(pr2).and(pr3);

        System.out.println("Test predicate: " + "J2222A: "+ resPredicate.test("J2222A"));
        System.out.println("Test predicate: "+"N2222A: " +resPredicate.test("N2222A"));
        System.out.println("Test predicate: "+"A2222A: " +resPredicate.test("A2222A"));

    }
}

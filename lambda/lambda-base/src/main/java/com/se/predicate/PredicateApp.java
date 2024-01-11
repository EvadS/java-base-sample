package com.se.predicate;

import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {
        Predicate<Integer>  predicate =  s -> s > 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(100));
        System.out.println(predicate.test(0));

        Predicate<String>  predicateNotNull  =  s ->  s!= null;
        Predicate<String>  predicateNotEmpty  =  s -> !s.equals("");

        System.out.println("predicateNotNull: " + predicateNotNull.test(null));
        System.out.println("predicateNotNull: " + predicateNotNull.test("100"));

        System.out.println("predicateNotEmpty: "+predicateNotEmpty.test(""));
        System.out.println("predicateNotEmpty: "+predicateNotEmpty.test("0"));

        Predicate<String> predicate3 = predicateNotNull.and(predicateNotEmpty);

        System.out.println("predicate3: "+predicate3.test(""));
        System.out.println("predicate3: "+predicate3.test(null));
        System.out.println("predicate3: "+predicate3.test("0"));
    }



}

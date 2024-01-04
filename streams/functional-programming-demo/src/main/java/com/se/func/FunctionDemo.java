package com.se.func;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
    }

    public void demo2() {

        Function<String, Integer> func = x -> x.length();

        Integer apply = func.apply("mkyong");   // 6

        System.out.println(apply);

    }


    public void demo1() {

        Function<String, Integer> func = x -> x.length();

        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result = func.andThen(func2).apply("mkyong");   // 12

        System.out.println(result);
    }
}

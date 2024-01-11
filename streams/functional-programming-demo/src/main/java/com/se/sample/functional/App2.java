package com.se.sample.functional;

import com.se.sample.interfaces.ExponentiationInterface;

import java.util.function.Function;

public class App2 {

    public void demo (){
        Function<Integer, Integer> quadratic =
                value -> value * value;
        Integer apply = quadratic.apply(2);
        System.out.println("apply: " +  apply);

        ExponentiationInterface<String, Integer> quadratic2 =
                variable -> {
                    int i = variable * variable;
                    return  String.format("%d", i);
                };        ;
    }

    public static void main(String[] args) {
        App2 app = new App2();
        app.demo();

        int a ;

    }
}

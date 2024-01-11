package com.se.function;

import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {
        Function<Integer, String> function = i->  {
                if(i>0){
                    return "положительное число";
                }
                else if(i<0)
                {
                    return  "отрицательное число";
                }
                return "ноль";
        };

        System.out.println(function.apply(-1));
        System.out.println(function.apply(1));
        System.out.println(function.apply(0));

        System.out.println("------------------------");

        Function<String, String> f1 = s -> s + "1";
        Function<String, String> f2 = s -> s + "2";
        Function<String, String> f3 = s -> s + "3";
        Function<String, String> f4 = s -> s + "4";
        System.out.println(f1.andThen(f2).compose(f3).compose(f4).apply("Compose"));
        System.out.println(f1.andThen(f2).andThen(f3).apply("AndThen"));

    }
}

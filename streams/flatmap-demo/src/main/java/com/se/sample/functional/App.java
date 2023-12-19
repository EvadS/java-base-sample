package com.se.sample.functional;

import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello, functional world!");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, functional world!");
            }
        };

        runnable1.run();
    }

    Consumer<String> consumer = new Consumer<String>() {
        @Override
        public void accept(String s) {

        }
    };
}

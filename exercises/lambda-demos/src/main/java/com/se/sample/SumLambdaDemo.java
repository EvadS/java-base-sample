package com.se.sample;

import java.util.Scanner;

/**
 * Write a Java program to implement a lambda expression to find the sum of two integers.
 */
public class SumLambdaDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println("result: "+ calculate(num1,num2));

        SumOperation operation = new SumOperation() {
            @Override
            public int calculate(int x, int y) {
                return x+y;
            }
        };

    }

    public static int  calculate(int num1 , int num2){
        //using the lambda expression
        SumOperation operation = (x, y) -> x + y;
        return  operation.calculate(2,3);
    }

    /**
     *  a functional interface
     */
    interface SumOperation {
        /**
         * abstract method called sum that takes two integer parameters and returns an integer result.
         * @param x
         * @param y
         * @return
         */
        int calculate(int x, int y);
    }
}


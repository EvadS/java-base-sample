package com.se.sample;

/**
 * Hello world!
 */
public class App {

    private static int testIntProp = 10;

    public static void main(String[] args) {
        int value = 7 ;
        value = calculate(value);

       System.out.println("Hello World!");
    }

    private static int calculate(int data) {

        int tempValue = data + 3 ;
        int newValue = tempValue *2;
        return newValue ;
    } // all local variables after this line pop from stack and destroy
}

package com.se.sample;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner input = new Scanner(System.in);
        int number1; // first number to compare

        System.out.print( "Input first integer: " ); // prompt
        number1 = input.nextInt(); // read first number from user

        System.out.println( "Hello World!" + number1 + "times" );
    }
}

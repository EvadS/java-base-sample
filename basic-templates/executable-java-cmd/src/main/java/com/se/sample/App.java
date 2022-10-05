package com.se.sample;

import java.util.Properties;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Command-Line arguments are");

        // loop through all arguments
        for(String str: args) {
            System.out.println(str);
        }

        // check cmd options
        // List all System properties
        Properties pros = System.getProperties();
        pros.list(System.out);

        pressEnterToContinue();
    }

    private static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {
        }
    }
}

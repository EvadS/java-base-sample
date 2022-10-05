package com.se.sample;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("Hello World!");
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

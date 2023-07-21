package com.se.sample;

import java.util.Scanner;

/**
 * compute the sum of an integer's digits.
 */
public class Exercise2 {

    public static int sumDigits(long n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

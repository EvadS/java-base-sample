package com.se.sample;

/**
 *  Java program to accept an integer and count the factors of the number.
 */
public class FactorOfNumber {

    public static int result(int num) {
        int ctr = 0;
        for(int i=1; i<=(int)Math.sqrt(num); i++) {
            if(num%i==0 && i*i!=num) {
                ctr+=2;
            } else if (i*i==num) {
                ctr++;
            }
        }
        return ctr;
    }
}

package com.se.algorithm;

/**
 * How to check whether a string is a rotation of another string
 */
public class RotationStringCheck {

    public static boolean checkRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        String str3 = str1 + str1;

        if(str3.contains(str2)){
            return true;

        }

        return  false;
    }

    public static void main(String[] args) {
        String str1 = "avajava";
        String str2 = "javaava2";

        System.out.println("Checking ");

        if(checkRotation(str1,str2)){
            System.out.println("Yes "+ str2 + " is rotation of " + str1);
        }
        else{
            System.out.println("Yes "+ str2 + " is not  rotation of " + str1);
        }
    }
}

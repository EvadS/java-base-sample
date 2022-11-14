package com.se.algorithm;

/**
 * Check if the given String is Palindrome
 */
public class PalindromeChecking {

    private PalindromeChecking() {

    }

    public static void main(String[] args) {
        System.out.println("is zyz palindrome: " + isPalindrome("zyz"));
        System.out.println("is zyz2 palindrome: " + isPalindrome("zyz2"));

        System.out.println("is z "+isPalindrome("z"));

    }

    public static boolean isPalindrome(String checkingString) {

        if (checkingString == null || checkingString.length() < 2) {
            return false;
        }

        StringBuilder sb = new StringBuilder(checkingString);
        return checkingString.equals(sb.reverse().toString());
    }
}

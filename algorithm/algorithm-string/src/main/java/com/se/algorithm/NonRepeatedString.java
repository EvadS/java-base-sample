package com.se.algorithm;

/**
 *  Print the first non-repeated character from String
 */
public class NonRepeatedString {
    /**
     * Consider the word swiss . First non repeating word is w . Creating a table to hold the count of each character
     * and then selecting the first item that is not repeated is one technique to handle this challenge.
     *
     * Because LinkedHashMap retains insertion order and we’re putting characters in the order they occur in String,
     * we merely need to go over LinkedHashMap and pick the item with value 1 once we’ve read String. Yes, one
     * LinkedHashMap and two loops are required for this approach.
     */

    public  static  void findNoNRepeatedCharacter(String input ){

        for(int i =0; i < input.length();i++){
          // int cur = ;
          // int next =  ;

            if(input.indexOf( input.charAt(i), input.indexOf(input.charAt(i+1))) == -1){
                System.out.println("First non-repeating character is " + input.charAt(i));
                break;
            }
        }

    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        findNoNRepeatedCharacter(s);
    }
}

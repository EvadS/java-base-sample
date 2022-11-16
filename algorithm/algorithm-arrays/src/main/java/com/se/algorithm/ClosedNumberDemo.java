package com.se.algorithm;

import java.util.Arrays;

/**
 * How to find the closest number to 0 in a given array
 */
public class ClosedNumberDemo {

    public static void main(String[] args) {
        sort(0, 5);
        System.out.println("---------------------------------");

        // searched element not found
        sort(100, 5);
        System.out.println("---------------------------------");

        // closed  element not found
        sort(0, 500);
        System.out.println("---------------------------------");

    }

    /**
     * @param searchNum      number for search closest
     * @param searchedCloses num  witch closes value
     */
    public static void sort(int searchNum, int searchedCloses) {
        int array[] = {5, 15, 76, 75, 5, 83, 54, 27, 89, 11, 0, 19, 5, 7, 42, 57, 5, 71, 27};

        System.out.println("Initial array");
        System.out.println(Arrays.toString(array));


        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNum) {
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("Searched element no found ");
            return;
        }

        System.out.println("searched elements has index: " + index);
        int currentDistance = array.length;
        int searchedNumIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchedCloses) {
                if (currentDistance > Math.abs(i - index)) {
                    currentDistance = Math.abs(i - index);
                    searchedNumIndex = i;
                }
            }
        }

        if(searchedNumIndex ==-1 ){
            System.out.println("Closed element not found");
            return;
        }
        ;
        System.out.println("closed element has index: " + searchedNumIndex);
    }

}

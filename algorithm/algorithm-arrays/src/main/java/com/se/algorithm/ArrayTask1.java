package com.se.algorithm;

import java.util.Arrays;

/**
 * How to find the second largest integer in the array
 * <p>
 * There are couple of methods to find the second-largest integer from the array. We can sort the array in the
 * descending order and return the second element. Here, we may have to traverse the array many times.
 * But we can find the second-largest integer with an optimal approach which traverse the array only once.
 */
public class ArrayTask1 {

    public static void main(String[] args) {
        System.out.println("find the second largest integer in the array");
        sort();
    }

    public static void sort() {

        int[] array =// {7, 46, 90, 94};
        ArrayUtils.generateWithStream();

//        int [] tmp = array;
//        Arrays.sort(tmp);
//        System.out.println("sorted: ---");
//        System.out.println(Arrays.toString(tmp));
//        System.out.println("-------------");

        int current = -1;
        int first = -1;
        int second = -1;

        printArray(array);

        if (array.length < 1) {
            first = array[0];
            second = array[0];
        }

        // if the current_integer>first => first=current & second = first
        // if the second<current_integer<first => second = current_integer
        for (int i = 0; i < array.length; i++) {
            current = array[i];
            if (current > first) {
                System.out.println("1. current: " + current + " > first: " + first);
                second = first;
                first = current;
                System.out.println("1.1 current: "+ current + " second: " + second);

            }

            if(current <first && second< current){
                System.out.println("2. current: " + current + " < first: " + first + " &&  second: "+ second + " < current: " + current );
                second = current;
            }

        }

        System.out.println("first number: " + first);
        System.out.println("second number: " + second);


    }

    public static void printArray(int[] array) {
        System.out.println("Current array");
        System.out.println(Arrays.toString(array));
    }
}

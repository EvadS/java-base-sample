package com.se.algorithm;

import java.util.Random;
import java.util.stream.IntStream;

public final  class ArrayUtils {

    private ArrayUtils() {

    }

    private static int[] generateArray(int min, int max) {          // generate a random size array with random numbers
        Random rd = new Random();                                   // random class will be used
        int randomSize = min + rd.nextInt(max);                     // first decide the array size (randomly, of course)
        System.out.println("Random array size: " + randomSize);
        int[] array = new int[randomSize];                          // create an array of that size
        for (int i = 0; i < randomSize; i++) {                      // iterate over the created array
            array[i] = min + rd.nextInt(max);                       // fill the cells randomly
        }
        return array;
    }

    public static int[] generateWithStream() {
        // generate 100 random number between 0 to 100
        return IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
    }
}
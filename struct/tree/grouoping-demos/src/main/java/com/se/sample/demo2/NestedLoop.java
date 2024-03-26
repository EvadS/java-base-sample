package com.se.sample.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NestedLoop {

    private static final Logger logger = LogManager.getLogger(NestedLoop.class);

    public static void main( String[] args )
    {
        // step1
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }

       logger.info("=========================");

        // step2
        int[][] array2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Arrays.stream(array2)
                .flatMapToInt(i -> Arrays.stream(i))
                .forEach(j ->logger.info(j));



        int a=0;
    }
}

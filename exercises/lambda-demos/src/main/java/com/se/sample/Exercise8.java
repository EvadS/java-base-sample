package com.se.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;

/**
 *   lambda expression to implement a lambda expression to calculate the factorial of a given number.
 */
public class Exercise8 {
    public static void main(String[] args) {
        // Create a list of strings

        Factorial factorial = (x) -> {
            /// только положительные числа
            if(x<0){
                return  0;
            }
            //Факториал нуля равен единице
            int result = 1;
            for(int i = 1 ; i <  x ; i++){
                result += result * i;
            }

            return result;
        };


        int calculate = factorial.calculate(0);
        System.out.println("Calculate result 0: " + calculate);

        calculate = factorial.calculate(5);
        System.out.println("Calculate result 5: " + calculate);

        calculate = factorial.calculate(7);
        System.out.println("Calculate result 7: " + calculate);


        Factorial factorial2 = (int x) -> {
            /// только положительные числа
            if(x<0){
                return  0;
            }
            //Факториал нуля равен единице
            int result = 1;
            for(int i = 1 ; i <  x ; i++){
                result += result * i;
            }

            return result;
        };

        calculate = factorial.calculate(10);
        System.out.println("Calculate result 10: " + calculate);

       // check this instead of own functional interface
      //   LongUnaryOperator
    }

    interface Factorial{
        int calculate (int number);
    }
}

package com.se.sample.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaBases {


    @Test
    public void sumarize_should_work_correct() {

        Stream<Integer> range = Stream.of(1,2,3,4,5,6,7,8,9,10);
        int sum = getSum(range);

        Stream<Integer> integerStream = IntStream.range(0, 100)
                .mapToObj(i -> 1);
        int sum2 = getSum(integerStream);

        Assert.assertNotNull(sum);
    }

    /**
     *
     * @param s
     * @returnwwwwwwwwwwwww
     */
    public int getSum(Stream<Integer> s) {
        // compile error
        // int sum =0;
        int[] sum = new int[1];

        s.forEach(i -> sum[0] += i);
        return sum[0];

    }


    public int getSum2(Stream<Integer> s) {

        Integer reduced = s.reduce(0, (x, y) -> x + y);
        return reduced;

    }
}

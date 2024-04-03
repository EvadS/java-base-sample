package com.se.sample;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    List<Object> myList = Arrays.asList("", 3, 'A', new Object());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @Test
    public void hamcrestBuiltInTestExactlyOneInstance() {
        long theNumberOfStringsInMyList = myList.stream().filter(o -> o instanceof String).count();
        Assert.assertEquals(theNumberOfStringsInMyList , 1L);
    }
}

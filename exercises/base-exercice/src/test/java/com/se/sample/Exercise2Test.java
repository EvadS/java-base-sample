package com.se.sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise2Test {

    @Test
    void shouldCalcCorrect(){
        int res = Exercise2.sumDigits(25);
        assertEquals(7 , res);
    }

    @Test
    void shouldCalcCorrectZero(){
        int res = Exercise2.sumDigits(0);
        assertEquals(0 , res);
    }

}
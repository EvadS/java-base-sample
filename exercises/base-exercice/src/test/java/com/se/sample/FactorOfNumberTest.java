package com.se.sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorOfNumberTest {

    @Test
    public void factorOfNumberShouldWorkCorrect() {
        int result = FactorOfNumber.result(25);

        assertEquals(3, result);
    }
}
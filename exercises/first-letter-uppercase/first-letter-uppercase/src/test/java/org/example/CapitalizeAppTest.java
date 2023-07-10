package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CapitalizeAppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void convertLetterToUpperCaseShouldWorkCorrect(){

        String inputRow = "Now is the time to act!";
        String outputRow = "NoW is thE tiMe to acT!";
        int charPosition = 2;
        String converted = CapitalizeApp.convertLetterToUpperCase(inputRow, charPosition);

        Assert.assertEquals(outputRow, converted);
    }

    @Test
    public void convertLetterToUpperCaseShouldWorkCorrectEmptyString(){
        String inputRow = "Now is th2 time to act!";
        String outputRow = "NoW is th2 tiMe to acT!";
        int charPosition = 2;
        String converted = CapitalizeApp.convertLetterToUpperCase(inputRow, charPosition);

        Assert.assertEquals(outputRow, converted);
    }


    @Test
    public void convertLetterToUpperCaseShouldWorkSmallWordLength(){
        String inputRow = "Now is th ti to act!";
        String outputRow = "NoW is th ti to acT!";
        int charPosition = 2;
        String converted = CapitalizeApp.convertLetterToUpperCase(inputRow, charPosition);

        Assert.assertEquals(outputRow, converted);
    }

    @Test
    public  void convertLetterToUpperCaseShouldWorkWithDigits() {
        String inputRow = "1111 222 333 444";
        String outputRow = "1111 222 333 444";
        int charPosition = 2;
        String converted = CapitalizeApp.convertLetterToUpperCase(inputRow, charPosition);

        Assert.assertEquals(outputRow, converted);
    }

    @Test
    public  void convertLetterToUpperCaseShouldWorkWithEmpty() {
        String inputRow = "";
        String outputRow = "";
        int charPosition = 2;
        String converted = CapitalizeApp.convertLetterToUpperCase(inputRow, charPosition);

        Assert.assertEquals(outputRow, converted);
    }
}

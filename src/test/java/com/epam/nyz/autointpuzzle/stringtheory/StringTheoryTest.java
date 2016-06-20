package com.epam.nyz.autointpuzzle.stringtheory;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringTheoryTest {
    
    private StringTheory stringTheory;
    
    @BeforeMethod
    public void init() {
        stringTheory = new StringTheory();
    }
    
    @DataProvider(name="inputExpectedOutput")
    public Object[][] inputExpectedOutputMap() {
        return new Object[][] {
            // 1 2 3 4  5  6  7  8
            // --------------------
            // 1 3 6 10 15 21 28 36
            //   2 5 9  14 20 27 35
            //     3 7  12 18 25 33
            //       4  9  15 22 30
            { "'a'b''", 1 }, // 1 1 1 1 2 // 1 1 2
            /**
             * 1 -> 1
             * 1 -> -
             * 2 -> 2
             * - -> #
             * 
             * 1 -> 1
             * 1 -> -
             * 2 -> 1
             * 1 -> !
             */
            { "'''a'b'a'''", 2 }, // 3 1 1 1 1 1 3 // 3 1 1 3
            /**
             * 3 -> 3
             * 1 -> 3 #
             * 
             * 3 -> 2
             * 1 -> 2 1
             * 1 -> 2
             * 1 -> 2 1
             * 3 -> 2
             * 2 -> 2
             * - -> #
             * 
             * 3 -> 2
             * 1 -> 2 1
             * 1 -> 2
             * 1 -> 2 1
             * 3 -> 2
             * 2 -> 1
             * 1 -> !
             */
            { "''a'b'''", 2 }, // 2 1 1 1 3 // 2 1 3
            /**
             * 2 -> 2
             * 1 -> 2 1
             * 3 -> 2
             * 2 -> !
             */
            { "''ab", 1 }, // 2 2 // 2
            /**
             * 2 -> 2
             * - -> #
             * 
             * 2 -> 1
             * 1 -> !
             */
            { "'", 0 }, // 1 // 1
            /**
             * 1 -> 1
             * - -> #
             * 
             * 1 -> 0
             * 
             */
            { "ab", 0 }, // 0 2 // -
            { "aa''''bb", 1 }, // 0 2 4 2 // 4 -> 2 2 -> 1 1 1 1
            /**
             * 4 -> 4
             * - -> #
             * 
             * 4 -> 3
             * 1 -> #
             * 
             * 4 -> 2
             * 2 -> 2 1
             * 1 -> 2
             * - -> #
             * 
             * 4 -> 1
             * 3 -> -
             * 2 -> 2
             * - -> #
             * 
             * 4 -> 1
             * 3 -> -
             * 2 -> 1
             * 1 -> !
             */
            { "''''''''''''", 3 }, // 12 -> 3 2 1 1 2 3
            /**
             * 12 -> 12
             * -  -> #
             * 
             * 12 -> 11
             * 1  -> #
             * 
             * 12 -> 10
             * 2  -> #
             * 
             * 12 -> 9
             * 3  -> #
             * 
             * 12 -> 8
             * 4  -> #
             * 
             * 12 -> 7
             * 5  -> #
             * 
             * 12 -> 6
             * 6  -> #
             */
            { "a''''''''''''a", 3 }, // 
            { "a'''b''c'd'c''''c'd'c''b'''a", 3 }, // 3 2 1 1 4 1 1 2 3 ->  
        };
    }
    
    @Test(dataProvider="inputExpectedOutput")
    public void getMaxNestingLevelInKQuotedStringShouldReturnExpectedValues( String input, int expected ) {
        int actual = stringTheory.getMaxNestingLevelInKQuotedString(input);
        assertEquals(actual, expected);
    }
    
}

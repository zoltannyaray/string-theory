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
            // 1 1 2 3 5 8 13 
//            { "'a'b''", 1 }, // 1 1 1 1 2 // 1 1 2
//            { "'''a'b'a'''", 2 }, // 3 1 1 1 1 1 3 // 3 1 1 3 
//            { "''a'b'''", 2 }, // 2 1 1 1 3 // 2 1 3
//            { "''ab", 1 }, // 2 2 // 2
//            { "'", 0 }, // 1 // 1
//            { "ab", 0 }, // 0 2 // -
            { "aa''''bb", 1 }, // 0 2 4 2 // 4 -> 2 2 -> 1 1 1 1
//            { "''''''''''''", 3 }, // 12 -> 3 2 1 1 2 3 
//            { "a''''''''''''a", 3 }, // 
//            { "a'''b''c'd'c''''c'd'c''b'''a", 3 }, // 3 2 1 1 4 1 1 2 3 ->  
        };
    }
    
    @Test(dataProvider="inputExpectedOutput")
    public void getMaxNestingLevelInKQuotedStringShouldReturnExpectedValues( String input, int expected ) {
        int actual = stringTheory.getMaxNestingLevelInKQuotedString(input);
        assertEquals(actual, expected);
    }
    
}

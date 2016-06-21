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
            { "'a'b''", 1 },
            { "''All 'work' and no 'play'''", 2 },
            { "'''a'b'a'''", 2 }, 
            { "''a'b'''", 2 },
            { "''ab", 1 },
            { "ab", 0 },
            { "aa''''bb", 1 },
            { "''''''''''''", 3 }, 
            { "a''''''''''''a", 3 }, 
            { "a'''b''c'd'c''''c'd'c''b'''a", 3 },
            { "''''a'''b''c'd'c''''c'd'c''b'''a", 3 },
            { "''''''''''''''''''''''", 4 },
            { "", 0 },
            { "'a' ''a'b'a'' '''a''b'c'b''a''' ''''a'''b''c'd'c''b'''a'''' ''''a'''b''c'd'c''b'''a'''' 'a' ''a'b'a''", 4 }
        };
    }
    
    @Test(dataProvider="inputExpectedOutput")
    public void getMaxNestingLevelInKQuotedStringShouldReturnExpectedValues( String input, int expected ) {
        int actual = stringTheory.getMaxNestingLevelInKQuotedString(input);
        assertEquals(actual, expected);
    }
    
    @DataProvider(name="inputExpectedException")
    public Object[][] inputExpectedException() {
        return new Object[][] {
            { "'" },
            { "'''''a'''b''c'd'c''''c'd'c''b'''a"},
            { "''a' ''a'b'a'' '''a''b'c'b''a''' ''''a'''b''c'd'c''b'''a'''' 'a' ''a'b'a''" }
        };
    }
    
    @Test(dataProvider="inputExpectedException", expectedExceptions=RuntimeException.class, expectedExceptionsMessageRegExp="Illegal K-quoted string!")
    public void getMaxNestingLevelInKQuotedStringShouldThrowRuntimeException( String input) {
        int actual = stringTheory.getMaxNestingLevelInKQuotedString(input);
    }
    
}

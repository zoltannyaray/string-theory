package com.epam.nyz.autointpuzzle.stringtheory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTheory {

    public int getMaxNestingLevelInKQuotedString( String input ) {
        Pattern pattern = Pattern.compile("'+");
        Matcher matcher = pattern.matcher(input);
        int maxPossible = 0;
        while ( matcher.find() ) {
            int possible = matcher.group(0).length();
            if ( possible > maxPossible ) {
                maxPossible = possible; 
            }
        }
        boolean resultFound = false;
        int result = 0;
        for ( int i = maxPossible; i > 0 && !resultFound; i-- ) {
            String regex = "([^']|^)'{" + i + "}(.*?)'{" + i + "}([^']|$)";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(input);
            while ( !resultFound && matcher.find() ) {
                if ( getMaxNestingLevelInKQuotedString(matcher.group(2)) == (i - 1)) {
                    resultFound = true;
                    result = i;
                }
            }
        }
        return result;
    }
    
}

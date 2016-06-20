package com.epam.nyz.autointpuzzle.stringtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTheory {

    public int getMaxNestingLevelInKQuotedString(String input) {
        List<String> kQuotedStringRegexes = new ArrayList<>();
        kQuotedStringRegexes.add("[^']*");
        int k = 1;
        while ( k < input.length() && input.matches(".*'{" + k + "}.*")) {
            kQuotedStringRegexes.add("([^']*'{" + k + "}" + kQuotedStringRegexes.get(k - 1) + "'{" + k + "}[^']*)+");
            k++;
        }
        int maxNestingLevel = 0;
        boolean isKQuoteStringFound = false;
        k = kQuotedStringRegexes.size() - 1;
        while (k >= 0 && !isKQuoteStringFound) {
            Pattern pattern = Pattern.compile(kQuotedStringRegexes.get(k));
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                isKQuoteStringFound = true;
                maxNestingLevel = k;
            }
            k--;
        }
        return maxNestingLevel;
    }

}

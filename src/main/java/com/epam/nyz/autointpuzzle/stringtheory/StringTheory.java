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
        while (k < input.length() && input.matches(".*'{" + k + "}.*")) {
            kQuotedStringRegexes.add("([^']*'{" + k + "}" + kQuotedStringRegexes.get(k - 1) + "'{" + k + "}[^']*)+");
            k++;
        }
        kQuotedStringRegexes.set(0, "^[^']*$");
        int maxNestingLevel = 0;
        boolean isMaxNestedKQuoteStringFound = false;
        k = kQuotedStringRegexes.size() - 1;
        while (k >= 0 && !isMaxNestedKQuoteStringFound) {
            Pattern pattern = Pattern.compile("(?<left>.*?)(" + kQuotedStringRegexes.get(k) + ")(?<right>.*)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                try {
                    if (matcher.group("left").length() > 0) {
                        getMaxNestingLevelInKQuotedString(matcher.group("left"));
                    }
                    if (matcher.group("right").length() > 0) {
                        getMaxNestingLevelInKQuotedString(matcher.group("right"));
                    }
                    isMaxNestedKQuoteStringFound = true;
                    maxNestingLevel = k;
                } catch (RuntimeException e) {
                }
            }
            k--;
        }
        if (!isMaxNestedKQuoteStringFound) {
            throw new RuntimeException("Illegal K-quoted string!");
        }
        return maxNestingLevel;
    }

}

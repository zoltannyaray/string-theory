package com.epam.nyz.autointpuzzle.stringtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTheory {

    public int getMaxNestingLevelInKQuotedString(String input) {
        List<String> kQuotedStringRegexes = new ArrayList<>();
        kQuotedStringRegexes.add("[^']*");
        int i = 1;
        while ( i < input.length() && input.matches(".*'{" + i + "}.*")) {
            kQuotedStringRegexes.add("([^']*'{" + i + "}" + kQuotedStringRegexes.get(i - 1) + "'{" + i + "}[^']*)+");
            i++;
        }
        int maxNestingLevel = 0;
        boolean isFound = false;
        i = kQuotedStringRegexes.size() - 1;
        while (i >= 0 && !isFound) {
            Pattern pattern = Pattern.compile(kQuotedStringRegexes.get(i));
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                isFound = true;
                maxNestingLevel = i;
            }
            i--;
        }
        return maxNestingLevel;
    }

}

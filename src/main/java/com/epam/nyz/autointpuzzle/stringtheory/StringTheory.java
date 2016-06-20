package com.epam.nyz.autointpuzzle.stringtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTheory {

    public int getMaxNestingLevelInKQuotedString(String input) {
        Pattern pattern = Pattern.compile("'+");
        Matcher matcher = pattern.matcher(input);
        int maxPossible = 0;
        while (matcher.find()) {
            int possible = matcher.group(0).length();
            if (possible > maxPossible) {
                maxPossible = possible;
            }
        }
        List<String> regexes = new ArrayList<>();
        regexes.add("[^']*");
        for (int i = 1; i <= maxPossible; i++) {
            regexes.add("([^']*'{" + i + "}" + regexes.get(i - 1) + "'{" + i + "}[^']*)+");
        }
        int result = 0;
        boolean isFound = false;
        int i = regexes.size() - 1;
        while (i >= 1 && !isFound) {
            pattern = Pattern.compile(regexes.get(i));
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                isFound = true;
                result = i;
            }
            i--;
        }
        return result;
    }

}

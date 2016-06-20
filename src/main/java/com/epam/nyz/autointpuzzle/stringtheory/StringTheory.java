package com.epam.nyz.autointpuzzle.stringtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTheory {

    public int getMaxNestingLevelInKQuotedString2(String input) {
        Pattern pattern = Pattern.compile("'+");
        Matcher matcher = pattern.matcher(input);
        List<Integer> quoteGroups = new ArrayList<>();
        while (matcher.find()) {
            quoteGroups.add(matcher.group(0).length());
        }
        Stack<Integer> stack = new Stack<>();
        boolean isStackEating = true;
        while (!quoteGroups.isEmpty()) {
            Integer currentGroup = quoteGroups.get(0);
            if ( isStackEating ) {
                int canEatMax = currentGroup;
                if ( !stack.isEmpty() ) {
                    canEatMax = Math.max(currentGroup, stack.peek());
                }
                for (int i = canEatMax; i >= 1; i--) {
                    currentGroup -= i;
                    if (currentGroup == 0) {
                        quoteGroups.remove(0);
                    }
                    stack.push(i);
                    if ( i == 1 ) {
                        isStackEating = false;
                    }
                }    
            }
            
        }
        int result = 0;
        return result;
    }
    
}

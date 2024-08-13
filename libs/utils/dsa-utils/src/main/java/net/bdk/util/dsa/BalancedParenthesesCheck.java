package net.bdk.util.dsa;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Stack;

public class BalancedParenthesesCheck {
    public boolean perform(@NonNull String s) {
        if (s.isBlank()) {
            return false;
        }

        boolean hasBrackets = false;
        boolean hasBalancedBrackets = true;
        Stack<Character> openBrackets = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                hasBrackets = true;
                openBrackets.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                hasBrackets = true;

                if (openBrackets.isEmpty()) {
                    hasBalancedBrackets = false;
                    break;
                }

                char matchingBracket = openBrackets.pop();
                if ((c == ')' && matchingBracket != '(')
                    || (c == '}' && matchingBracket != '{')
                    || (c == ']' && matchingBracket != '[')) {
                    hasBalancedBrackets = false;
                    break;
                }
            }
        }

        if (!openBrackets.isEmpty()) {
            hasBalancedBrackets = false;
        }

        return hasBrackets && hasBalancedBrackets;
    }
}

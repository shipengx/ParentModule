package sf;

import java.util.Stack;

/**
 * Valid Parentheses
 * Given a String containing just the characters '(', ')', '{', '}', '[', ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. open brackets must be closed by the same type of brackets.
 * 2. open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char current = array[i];
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (current == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (current == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                continue;
            }
        } // end for loop

        return stack.isEmpty();
    }


}

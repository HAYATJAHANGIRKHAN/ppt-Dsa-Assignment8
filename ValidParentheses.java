//<aside>
//💡 **Question 2**
//
//        Given a string s containing only three types of characters: '(', ')' and '*', return true *if* s *is **valid***.
//
//        The following rules define a **valid** string:
//
//        - Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//        - Any right parenthesis ')' must have a corresponding left parenthesis '('.
//        - Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//        - '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
//
//        **Example 1:**
//
//        **Input:** s = "()"
//
//        **Output:**
//
//        true



package ppt_assignment8;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (s.charAt(index) == '(') {
                boolean hasMatchingRightParenthesis = false;
                for (int i = index + 1; i < s.length(); i++) {
                    if (s.charAt(i) == ')') {
                        hasMatchingRightParenthesis = true;
                        break;
                    }
                }
                if (!hasMatchingRightParenthesis) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        boolean isValid = isValid(s);
        System.out.println(isValid);
    }
}

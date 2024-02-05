package com.javadroider.interviewprep.blind75.week1;

import java.util.Stack;

public class _0020_ValidParanthesis {

    public static void main(String[] args) {
        System.out.println(new _0020_ValidParanthesis().isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }
}

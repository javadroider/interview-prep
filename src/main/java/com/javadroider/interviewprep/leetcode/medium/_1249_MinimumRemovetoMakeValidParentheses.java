package com.javadroider.interviewprep.leetcode.medium;

import java.util.Stack;

public class _1249_MinimumRemovetoMakeValidParentheses {

    public static void main(String[] args) {
        //System.out.println(minRemoveToMakeValid2("))(("));
        //System.out.println(minRemoveToMakeValid2("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("a(b(c)d"));
    }

    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/474353/Stack-Based-or-Easy-to-Understand-or-Faster-than-99-or-JavaScript-Solution
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ("(".equals(arr[i])) {
                stack.push(i);
            } else if (")".equals(arr[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = "";
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = "";
        }
        return String.join("", arr);
    }

}

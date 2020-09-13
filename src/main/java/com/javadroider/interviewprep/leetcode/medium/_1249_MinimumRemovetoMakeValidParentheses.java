package com.javadroider.interviewprep.leetcode.medium;

import java.util.Stack;

public class _1249_MinimumRemovetoMakeValidParentheses   {

    public static void main(String[] args) {
        //System.out.println(minRemoveToMakeValid2("))(("));
        //System.out.println(minRemoveToMakeValid2("a)b(c)d"));
        System.out.println(minRemoveToMakeValid2("a(b(c)d"));
    }

    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/474353/Stack-Based-or-Easy-to-Understand-or-Faster-than-99-or-JavaScript-Solution
    public static String minRemoveToMakeValid2(String s) {
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

    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419702/Java-O(n)-solution-without-Stack
    public String minRemoveToMakeValid(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(n);
        boolean[] remove = new boolean[n];
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else if (str.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    remove[i] = true;
                }
            }
        }
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == ')') {
                close++;
            } else if (str.charAt(i) == '(') {
                if (close > 0) {
                    close--;
                } else {
                    remove[i] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!remove[i]) sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}

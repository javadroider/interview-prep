package com.javadroider.interviewprep.leetcode.medium;

import java.util.Stack;

public class _0227_BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(new _0227_BasicCalculatorII().calculate("3*2*2"));
    }

    //https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
    public int calculate1(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s += '+';
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n = n * 10 + c - '0';
                continue;
            }
            if (c == ' ') continue;
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop() * n);
            else if (op == '/') stack.push(stack.pop() / n);
            op = c;
            n = 0;
        }

        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }


    public int calculate(String s) {
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
                switch(lastSign) {
                    case '+':
                        sum+=tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        sum+=tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                lastSign = c;
                num=0;
            }
        }
        sum+=tempSum;
        return sum;
    }
}

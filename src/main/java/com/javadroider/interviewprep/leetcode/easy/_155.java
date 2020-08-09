package com.javadroider.interviewprep.leetcode.easy;

import java.util.Stack;

public class _155 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }


    static class MinStack {

        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> stack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                if (x < minStack.peek()) {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            int x = stack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

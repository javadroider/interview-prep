package com.javadroider.interviewprep.leetcode.easy;

import java.util.Stack;

public class _0155_MinStack {

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

        private Node head = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x, null);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    static class MinStack1 {

        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> stack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack1() {

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

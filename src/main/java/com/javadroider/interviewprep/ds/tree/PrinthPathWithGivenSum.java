package com.javadroider.interviewprep.ds.tree;

import java.util.Stack;

public class PrinthPathWithGivenSum {

    /*
		    10
		  /   \
		 8     12
		/ \   /  \
		7  9  11  13

	*/
    static void print(Node node, Stack<Node> stack, int sum, int k) {
        if (node == null) {
            return;
        }
        sum = sum + node.data;
        stack.push(node);
        print(node.left, stack, sum, k);
        if (sum == k) {
            System.out.println(stack);
        }
        print(node.right, stack, sum, k);
        stack.pop();
    }

    public static void main(String[] args) {
        Node node = BinaryTree.sample();
        print(node, new Stack<>(), 0, 22);
    }
}

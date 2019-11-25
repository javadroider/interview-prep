package com.javadroider.interviewprep.ds.tree;

import java.util.Stack;

public class PrintPathsOfTree {

    static void printPaths(Node node, int path[], int pathLen) {
        if (node == null) {
            return;
        }
        path[pathLen] = node.data;
        if (node.left == null && node.right == null) {

            for (int i = 0; i <= pathLen; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }
        printPaths(node.left, path, pathLen + 1);
        printPaths(node.right, path, pathLen + 1);

    }

    static void printUsingStack(Node node, Stack<Node> stack) {
        if (node == null) {
            return;
        }
        stack.push(node);
        printUsingStack(node.left, stack);
        if (node.left == null && node.right == null) {
            System.out.println(stack);
        }
        printUsingStack(node.right, stack);
        stack.pop();

    }


    public static void main(String[] args) {
        Node node = BinaryTree.sample();
        //printPaths(node, interesting int[1000], 0);
        printUsingStack(node,new Stack<Node>());
    }
}

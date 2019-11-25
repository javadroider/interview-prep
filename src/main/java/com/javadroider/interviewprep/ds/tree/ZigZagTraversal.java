package com.javadroider.interviewprep.ds.tree;

import java.util.Stack;

public class ZigZagTraversal {

    static void zigzag(Node node) {

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(node);
        while (true) {

            while (!s1.empty()) {
                Node n1 = s1.pop();
                System.out.print(n1);
                if (n1.left != null) {
                    s2.push(n1.left);
                }
                if (n1.right != null) {
                    s2.push(n1.right);
                }
            }

            while (!s2.empty()) {
                Node n2 = s2.pop();
                System.out.print(n2);
                if (n2.right != null) {
                    s1.push(n2.right);
                }
                if (n2.left != null) {
                    s1.push(n2.left);
                }
            }

            if (s1.empty() && s2.empty()) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        Node node = BinaryTree.sample();
        zigzag(node);
    }
}

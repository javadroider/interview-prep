package com.javadroider.interviewprep.ds.tree;

public class LCAOfTree {
    static Node lca(Node node, Node n1, Node n2) {
        if (node == null) {
            return node;
        }
        if (node == n1 || node == n2) {
            return node;
        }
        Node left = lca(node.left, n1, n2);
        Node right = lca(node.right, n1, n2);
        if (left != null && right != null) {
            return node;
        } else {
            if (null != left) {
                return left;
            } else {
                return right;
            }
        }
    }

    public static void main(String[] args) {
        Node head = BinaryTree.sample();
        Node n1 = BinaryTree.find(head, 7);
        Node n2 = BinaryTree.find(head, 13);
        Node lca = lca(head, n1, n2);
        System.out.println(lca);
    }
}

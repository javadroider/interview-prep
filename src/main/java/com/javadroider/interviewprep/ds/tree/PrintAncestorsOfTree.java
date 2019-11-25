package com.javadroider.interviewprep.ds.tree;

public class PrintAncestorsOfTree {

    static boolean travserse(Node node, Node target) {
        if (node != null) {
            if (node == target) {
                return true;
            }
            if (travserse(node.left, target) || travserse(node.right, target)) {
                System.out.print(node);
                return true;
            }
        }
        return false;
    }

    /*
          10
        /   \
       8     12
      / \   /  \
     7  9  11  13
    */

    public static void main(String[] args) {
        Node head = BinaryTree.sample();
        Node nine = BinaryTree.find(head, 9);
        travserse(head, nine);
    }
}

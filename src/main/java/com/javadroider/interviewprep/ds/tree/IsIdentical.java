package com.javadroider.interviewprep.ds.tree;

public class IsIdentical {

    static boolean identical(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.data == n2.data && identical(n1.left, n2.left) && identical(n1.right, n2.right);
    }

    public static void main(String[] args) {
        Node n1 = BinaryTree.sample();
        Node n2 = BinaryTree.sample();
//        Node temp = BinaryTree.find(n2,13);
//        temp.data=14;
        System.out.println(identical(n1,n2));

    }
}

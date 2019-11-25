package com.javadroider.interviewprep.ds.tree;

public class DiameterOfTree {

    static int diameter(Node node) {
        if (node == null) {
            return 0;
        }

        int lHeight = BinaryTree.height(node.left);
        int rHeight = BinaryTree.height(node.right);

        int ld = diameter(node.left);
        int rd = diameter(node.right);

        return Math.max((lHeight + rHeight + 1), Math.max(ld, rd));
    }

    public static void main(String[] args) {
        int dia = diameter(BinaryTree.sample());
        System.out.println(dia);
    }
}

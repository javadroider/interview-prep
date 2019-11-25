package com.javadroider.interviewprep.ds.tree;

public class PrintNodesHavingKLeaves {

    static int print(Node node, int k) {
        if (node == null) {
            return 1;
        }
        int lc = print(node.left, k);
        int rc = print(node.right, k);

        int tc = lc + rc;
        if (tc == k) {
            System.out.println(node);
        }
        return tc;
    }

    public static void main(String[] args) {
        Node node = BinaryTree.sample();
        print(node,2);
    }
}

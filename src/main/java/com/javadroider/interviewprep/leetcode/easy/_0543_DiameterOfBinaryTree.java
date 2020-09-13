package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

public class _0543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);

        return Math.max(lHeight + rHeight, Math.max(ld, rd));

    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

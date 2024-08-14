package com.javadroider.interviewprep.blind75.week4;

import com.javadroider.interviewprep.util.TreeNode;

public class _0235_LowestCommonAncestorOfABinarySearchTree {

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solutions/4811053/easy-java-solution/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}

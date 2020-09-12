package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

public class _0112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int rSum = sum - root.val;
        if (root.left == null && root.right == null && rSum == 0) {
            return true;
        } else {
            return hasPathSum(root.left, rSum) || hasPathSum(root.right, rSum);
        }
    }
}

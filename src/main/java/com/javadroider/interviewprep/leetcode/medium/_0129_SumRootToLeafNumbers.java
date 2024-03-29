package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

public class _0129_SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int currentSum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        return sum(root.left, currentSum) + sum(root.right, currentSum);
    }
}

package com.javadroider.interviewprep.blind75.week3;

import com.javadroider.interviewprep.util.TreeNode;

public class _0124_BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(maxPathSum(root.left), 0);
        int rightSum = Math.max(maxPathSum(root.right), 0);
        int allSum = root.val + leftSum + rightSum;
        max = Math.max(max, allSum);
        return Math.max(leftSum, rightSum) + root.val;
    }

}

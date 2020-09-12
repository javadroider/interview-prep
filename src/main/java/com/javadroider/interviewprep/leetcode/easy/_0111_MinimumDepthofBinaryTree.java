package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

public class _0111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? (1 + left + right) : Math.min(left, right) + 1;
        //return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
}

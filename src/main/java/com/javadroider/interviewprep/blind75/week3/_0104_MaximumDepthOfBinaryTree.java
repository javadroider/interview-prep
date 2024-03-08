package com.javadroider.interviewprep.blind75.week3;

import com.javadroider.interviewprep.util.TreeNode;

public class _0104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}

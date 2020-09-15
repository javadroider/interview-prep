package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

public class _1026_MaximumDifferenceBetweenNodeAndAncestor {
    //https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC%2B%2BPython-Top-Down
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    private int maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return max - min;
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        return Math.max(maxAncestorDiff(root.left, max, min), maxAncestorDiff(root.right, max, min));
    }
}
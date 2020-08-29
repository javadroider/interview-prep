package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

public class _270 {

    //https://leetcode.com/problems/closest-binary-search-tree-value/discuss/70331/Clean-and-concise-java-solution
    public static void main(String[] args) {

    }

    public int closestValue(TreeNode root, double target) {

        int ret = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(ret - target)) {
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }

        return ret;
    }
}

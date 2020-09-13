package com.javadroider.interviewprep.leetcode.hard;

import com.javadroider.interviewprep.util.TreeNode;

public class _0124_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode minusThree = new TreeNode(-3);
        //System.out.println(new _0124_BinaryTreeMaximumPathSum().maxPathSum(minusThree));
        System.out.println(new _0124_BinaryTreeMaximumPathSum().maxPathSum(TreeNode.sample1()));
    }


    //https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/
    //https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lSum = Math.max(maxGain(root.left), 0);
        int rSum = Math.max(maxGain(root.right), 0);
        int allSum = lSum + rSum + root.val;
        maxSum = Math.max(maxSum, allSum);
        return Math.max(lSum, rSum) + root.val;
    }
}

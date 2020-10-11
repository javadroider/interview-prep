package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;


/*

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4


 */
public class _0270_ClosestBinarySearchTreeValue {

    //https://leetcode.com/problems/closest-binary-search-tree-value/discuss/70331/Clean-and-concise-java-solution
    public static void main(String[] args) {
        System.out.println(new _0270_ClosestBinarySearchTreeValue().closestValue(TreeNode.binarySearchTree(), 4.8));
    }

    //https://leetcode.com/problems/closest-binary-search-tree-value/solution/
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

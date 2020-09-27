package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

public class _0669_TrimABinarySearchTree {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/trim-a-binary-search-tree/discuss/107000/Java-solution-6-liner/314989
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        //post order traversal
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if(root.val < low){
            return root.right;
        }
        if(root.val > high){
            return root.left;
        }
        return root;
    }

    //https://leetcode.com/problems/trim-a-binary-search-tree/solution/
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}

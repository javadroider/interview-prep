package com.javadroider.interviewprep.blind75.week3;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Stack;

public class _0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) {
                break;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            } else {
                prev = root;
                root = root.right;
            }
        }
        return true;
    }
}
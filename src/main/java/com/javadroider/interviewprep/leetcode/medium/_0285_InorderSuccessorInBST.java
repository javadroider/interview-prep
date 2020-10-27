package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Stack;

public class _0285_InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
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
            if (prev == p) {
                return root;
            }
            prev = root;
            root = root.right;
        }
        return null;
    }
}

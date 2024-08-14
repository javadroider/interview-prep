package com.javadroider.interviewprep.blind75.week4;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Stack;

public class _0230_KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) {
                break;
            }
            count++;
            root = stack.pop();
            if (k == count) {
                return root.val;
            }
            root = root.right;
        }

        return -1;
    }
}

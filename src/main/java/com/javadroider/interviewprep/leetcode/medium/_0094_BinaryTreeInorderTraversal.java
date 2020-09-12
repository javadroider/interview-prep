package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.empty()) {
                break;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}

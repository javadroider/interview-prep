package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (true) {

            while (root != null) {
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }

            if (stack.empty()) {
                break;
            }

            root = stack.pop();
            root = root.right;
        }

        return list;
    }
}

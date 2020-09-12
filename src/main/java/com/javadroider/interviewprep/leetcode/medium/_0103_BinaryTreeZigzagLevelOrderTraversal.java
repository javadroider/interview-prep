package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root);
        List<Integer> list = new ArrayList<>();
        TreeNode temp = null;
        List<List<Integer>> output = new ArrayList<>();

        do {

            while (!stack1.empty()) {
                temp = stack1.pop();
                list.add(temp.val);
                if (temp.left != null) {
                    stack2.push(temp.left);
                }
                if (temp.right != null) {
                    stack2.push(temp.right);
                }
            }
            if (!list.isEmpty()) {
                output.add(list);
            }
            list = new ArrayList<>();
            while (!stack2.empty()) {
                temp = stack2.pop();
                list.add(temp.val);
                if (temp.right != null) {
                    stack1.push(temp.right);
                }
                if (temp.left != null) {
                    stack1.push(temp.left);
                }
            }
            if (!list.isEmpty()) {
                output.add(list);
            }
            list = new ArrayList<>();
        } while (!stack1.empty() || !stack2.empty());
        return output;
    }
}

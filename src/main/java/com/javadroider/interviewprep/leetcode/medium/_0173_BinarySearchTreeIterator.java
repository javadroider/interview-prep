package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Stack;

public class _0173_BinarySearchTreeIterator {

    class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode root = stack.pop();
            TreeNode temp = root.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            return root.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.empty();
        }
    }
}


package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0958_CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if (temp == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return true;
    }
}

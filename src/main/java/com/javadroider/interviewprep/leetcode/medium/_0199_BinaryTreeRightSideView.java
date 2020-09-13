package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0199_BinaryTreeRightSideView {

    public static void main(String[] args) {
        System.out.println(new _0199_BinaryTreeRightSideView().rightSideView(TreeNode.sample()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (null == root) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = 0;
            int size = queue.size();
            while (count < size) {
                TreeNode temp = queue.remove();
                if (count == size - 1) {
                    ret.add(temp.val);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                count++;
            }
        }

        return ret;
    }

}

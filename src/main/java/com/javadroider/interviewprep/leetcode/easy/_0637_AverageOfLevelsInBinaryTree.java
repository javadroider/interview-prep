package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0637_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int n = size;
            double sum = 0.0;
            while (n > 0) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

                n--;
            }
            ret.add(sum / size);
        }

        return ret;
    }
}

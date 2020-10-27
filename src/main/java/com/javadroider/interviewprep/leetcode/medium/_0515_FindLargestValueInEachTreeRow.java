package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0515_FindLargestValueInEachTreeRow {

    //https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98971/9ms-JAVA-DFS-solution/103078
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            res.add(max);
        }
        return res;
    }
}

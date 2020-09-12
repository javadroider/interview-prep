package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }

    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currentPath) {

        if (root == null || sum < 0) {
            return;
        }
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<>(currentPath));
            }
            return;
        }
        if (root.left != null) {
            pathSum(root.left, sum - root.val, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
        if (root.right != null) {
            pathSum(root.right, sum - root.val, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}

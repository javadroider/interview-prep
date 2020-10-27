package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePaths(root, res, "");
        return res;
    }

    private void binaryTreePaths(TreeNode root, List<String> res, String path) {

        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                res.add(path);
            } else {
                path += "->";
                binaryTreePaths(root.left, res, path);
                binaryTreePaths(root.right, res, path);
            }
        }
    }
}

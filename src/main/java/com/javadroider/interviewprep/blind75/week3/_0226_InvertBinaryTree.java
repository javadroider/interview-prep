package com.javadroider.interviewprep.blind75.week3;

import com.javadroider.interviewprep.util.TreeNode;

public class _0226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }
        TreeNode left = invertTree((root.left));
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

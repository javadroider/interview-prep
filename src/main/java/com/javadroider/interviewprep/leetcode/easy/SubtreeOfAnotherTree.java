package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.TreeNode;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        System.out.println(new SubtreeOfAnotherTree().isSubtree(TreeNode.sample(), new TreeNode(13)));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

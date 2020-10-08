package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Stack;

public class _0536_ConstructBinaryTreeFromString {


    public static void main(String[] args) {
        //TreeNode treeNode = new _0536_ConstructBinaryTreeFromString().str2tree("4(2(3)(1))(6(5))");
        TreeNode treeNode = new _0536_ConstructBinaryTreeFromString().str2tree("-4(2(3)(1))(6(5)(7))");
        //TreeNode treeNode = new _0536_ConstructBinaryTreeFromString().str2tree("51(232)(434)");
        treeNode.levelOrder(null);
    }

    //https://leetcode.com/problems/construct-binary-tree-from-string/discuss/100359/Java-stack-solution
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (c >= '0' && c <= '9' || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = currentNode;
                    } else {
                        parent.left = currentNode;
                    }
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}

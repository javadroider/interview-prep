package com.javadroider.interviewprep.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

        /*
              10
            /   \
           8     12
          / \   /  \
         7  9  11  13
    */

    public static TreeNode sample2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        return one;
    }

    public static TreeNode sample() {
        TreeNode ten = new TreeNode(10);
        TreeNode eight = new TreeNode(8);
        TreeNode twelve = new TreeNode(12);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode elven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);

        ten.left = eight;
        ten.right = twelve;
        eight.left = seven;
        eight.right = nine;
        twelve.left = elven;
        twelve.right = thirteen;
        return ten;
    }

    @Override
    public String toString() {
        return val + "";
    }
}

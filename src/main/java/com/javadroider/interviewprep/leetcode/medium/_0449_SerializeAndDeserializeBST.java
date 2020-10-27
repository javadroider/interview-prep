package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0449_SerializeAndDeserializeBST {

    public static void main(String[] args) {
        Codec instance = new Codec();
        String str = instance.serialize(null);
        System.out.println(str);
        TreeNode tree = instance.deserialize(str);
        tree.levelOrder(tree);
    }

    //https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(Queue<String> q, int lower, int upper) {
            if (q.isEmpty()) {
                return null;
            }
            String s = q.peek();
            int val = Integer.parseInt(s);
            if (val < lower || val > upper) {
                return null;
            }
            q.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(q, lower, val);
            root.right = deserialize(q, val, upper);
            return root;
        }
    }
}

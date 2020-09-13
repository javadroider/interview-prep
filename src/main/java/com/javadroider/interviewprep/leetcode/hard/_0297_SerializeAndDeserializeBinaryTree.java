package com.javadroider.interviewprep.leetcode.hard;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0297_SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        Codec instance = new Codec();
        String str1 = instance.serialize(TreeNode.sample());
        System.out.println(str1);
        TreeNode node = instance.deserialize(str1);
        String str2 = instance.serialize(node);
        System.out.println(str2);
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("EQUAL");
        }
    }


    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer("");
            serialize(sb, root);
            return sb.toString();
        }

        private void serialize(StringBuffer sb, TreeNode root) {
            if (root == null) {
                sb.append("#").append(",");
            } else {
                sb.append(root.val).append(",");
                serialize(sb, root.left);
                serialize(sb, root.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
        }

        private TreeNode deserialize(Queue<String> queue) {

            String val = queue.poll();
            if ("#".equalsIgnoreCase(val)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                node.left = deserialize(queue);
                node.right = deserialize(queue);
                return node;
            }

        }
    }

}

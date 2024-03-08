package com.javadroider.interviewprep.blind75.week3;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0297_SerializeAndDeserializeBinaryTree {


    public static void main(String[] args) {
        _0297_SerializeAndDeserializeBinaryTree instance = new _0297_SerializeAndDeserializeBinaryTree();
        String str1 = instance.serialize(TreeNode.sample());
        System.out.println(str1);
        TreeNode node = instance.deserialize(str1);
        String str2 = instance.serialize(node);
        System.out.println(str2);
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("EQUAL");
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String val = queue.poll();
        if ("#".equalsIgnoreCase(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}

package com.javadroider.interviewprep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTheTree {

    static int heightRecursive(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = heightRecursive(node.left);
            int rHeight = heightRecursive(node.right);
            if (lHeight > rHeight) {
                return lHeight + 1;
            } else {
                return rHeight + 1;
            }
        }
    }

    static int heightIterative(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);//way to identify level
        int height = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null) {
                if (!queue.isEmpty()) {
                    //marker for next level
                    queue.add(null);
                }
                height++;
            } else {
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Node node = BinaryTree.sample();
        System.out.println(heightRecursive(node));
        System.out.println(heightIterative(node));
    }
}

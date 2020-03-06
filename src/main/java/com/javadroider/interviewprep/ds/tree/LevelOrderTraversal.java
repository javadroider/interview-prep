package com.javadroider.interviewprep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {


    /*
              10
            /   \
           8     12
          / \   /  \
         7  9  11  13
    */

    private static void traverse(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        String str = "";
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(12, head);
        head = bt.addNode(8, head);
        head = bt.addNode(9, head);
        head = bt.addNode(13, head);
        head = bt.addNode(7, head);
        head = bt.addNode(11, head);
        traverse(head);
    }


}

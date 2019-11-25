package com.javadroider.interviewprep.ds.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TopViewOfTree {

    private static class QItem {
        Node node;
        int hd;

        public QItem(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node node) {
        Queue<QItem> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new QItem(node, 0));
        while (!queue.isEmpty()) {
            QItem temp = queue.remove();
            int hd = temp.hd;
            if (!set.contains(hd)) {
                set.add(hd);
                System.out.print(temp.node);
            }
            if (temp.node.left != null) {
                queue.add(new QItem(temp.node.left, hd - 1));
            }
            if (temp.node.right != null) {
                queue.add(new QItem(temp.node.right, hd + 1));
            }

        }
    }

    /*
          10
        /   \
       8     12
      / \   /  \
     7  9  11  13
*/
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

        topView(head);
    }
}

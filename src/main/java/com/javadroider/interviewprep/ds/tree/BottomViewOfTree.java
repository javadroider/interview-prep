package com.javadroider.interviewprep.ds.tree;

import java.util.*;

public class BottomViewOfTree {

    private static class QItem {
        Node node;
        int hd;

        public QItem(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }

        @Override
        public String toString() {
            return node.toString();
        }
    }

    /*
        hd = horizontal distance
        1. For root
            d=0
        2. For left child
            hd = hd - 1
        3. For right child
            hd = hd + 1
    */
    public static void bottomView(Node node) {
        Queue<QItem> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, QItem> map = new HashMap<>();
        queue.add(new QItem(node, 0));
        while (!queue.isEmpty()) {
            QItem temp = queue.remove();
            int hd = temp.hd;
            map.put(hd, temp);
            if (temp.node.left != null) {
                queue.add(new QItem(temp.node.left, hd - 1));
            }
            if (temp.node.right != null) {
                queue.add(new QItem(temp.node.right, hd + 1));
            }
        }
        Iterator<Map.Entry<Integer, QItem>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next().getValue());
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

        bottomView(BinaryTree.sample());
    }
}

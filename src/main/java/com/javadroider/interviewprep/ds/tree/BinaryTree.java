package com.javadroider.interviewprep.ds.tree;

class Node {
    Node left;
    Node right;
    int data;

    public static Node newNode(int data) {
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.data = data;
        return n;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

public class BinaryTree {
    public Node addNode(int data, Node head) {
        Node tempHead = head;
        Node n = Node.newNode(data);
        if (head == null) {
            head = n;
            return head;
        }
        Node prev = null;
        while (head != null) {
            prev = head;
            if (head.data < data) {
                head = head.right;
            } else {
                head = head.left;
            }
        }
        if (prev.data < data) {
            prev.right = n;
        } else {
            prev.left = n;
        }
        return tempHead;
    }

    public static Node find(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return node;
        }
        if (data < node.data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }


    /*
          10
        /   \
       8     12
      / \   /  \
     7  9  11  13
    */
    public static Node sample() {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(12, head);
        head = bt.addNode(8, head);
        head = bt.addNode(9, head);
        head = bt.addNode(13, head);
        head = bt.addNode(7, head);
        head = bt.addNode(11, head);
        return head;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(12, head);
        head = bt.addNode(8, head);
        head = bt.addNode(9, head);
        head = bt.addNode(13, head);
        head = bt.addNode(7, head);
        head = bt.addNode(11, head);
        System.out.println(bt.height(head));

    }
}

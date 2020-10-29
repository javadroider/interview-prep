package com.javadroider.interviewprep.leetcode.medium;

public class _0116_PopulatingNextRightPointersInEachNode {

    //based on level order traversal
    public Node connect(Node root) {
        Node head = null; //head of the next level
        Node prev = null; //the leading node on the next level
        Node cur = root;  //current node of current level

        while (cur != null) {
            //iterate on the current level
            //do update head pointer if prev is null
            while (cur != null) {
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }

        return root;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solution/
    public Node connect1(Node root) {

        if (root == null) {
            return root;
        }

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node runner = root;

        // Once we reach the final level, we are done
        while (runner.left != null) {

            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = runner;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Progress along the list (nodes on the current level)
                head = head.next;
            }

            // Move onto the next level
            runner = runner.left;
        }

        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}

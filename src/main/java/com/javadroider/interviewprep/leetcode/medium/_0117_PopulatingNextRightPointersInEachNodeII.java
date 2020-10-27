package com.javadroider.interviewprep.leetcode.medium;

public class _0117_PopulatingNextRightPointersInEachNodeII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

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
}

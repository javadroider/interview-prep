package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0138_CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();

        Node runner = head;
        while (runner != null) {
            map.put(runner, new Node(runner.val));
            runner = runner.next;
        }

        Node dummy = new Node(-1);
        runner = head;
        Node current = dummy;
        while (runner != null){
            Node temp = map.get(runner);
            temp.next = map.get(runner.next);
            temp.random = map.get(runner.random);
            current.next = temp;
            current = current.next;
            runner = runner.next;
        }
        return dummy.next;
    }
}

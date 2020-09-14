package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;

public class _0019_RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode.print(l1);
        System.out.println();
        _0019_RemoveNthNodeFromEnd instance = new _0019_RemoveNthNodeFromEnd();
        ListNode updatedNode = instance.removeNthFromEnd(l1, 2);
        ListNode.print(updatedNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode runner = newHead;
        while (n > 0) {
            runner = runner.next;
            n--;
        }
        while (runner.next != null) {
            runner = runner.next;
            p = p.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;

import java.util.List;

public class RemoveNthNodeFromEnd {
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
        RemoveNthNodeFromEnd instance = new RemoveNthNodeFromEnd();
        ListNode updatedNode = instance.removeNthFromEnd1(l1, 2);
        ListNode.print(updatedNode);
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if (null == head) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode sp = dummy;
        ListNode fp = dummy;

        while (n > 0) {
            fp = fp.next;
            n--;
        }

        while (fp.next != null) {
            sp = sp.next;
            fp = fp.next;
        }
        sp.next = sp.next.next;
        return head;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        /**
         *
         * [1.2] 1
         *
         *  p = 1
         *  r = 2
         *  n = 0
         *
         */
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

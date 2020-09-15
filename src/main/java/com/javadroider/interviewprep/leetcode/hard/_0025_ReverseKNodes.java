package com.javadroider.interviewprep.leetcode.hard;

import com.javadroider.interviewprep.util.ListNode;

public class _0025_ReverseKNodes {

    public ListNode reverseKGroup(ListNode head, int k) {

        int len = getLen(head);

        if (len < k) {
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        int counter = 0;

        while (curr != null && counter < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;


    }

    private int getLen(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }

}

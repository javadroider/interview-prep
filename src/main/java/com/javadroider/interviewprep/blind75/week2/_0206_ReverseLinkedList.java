package com.javadroider.interviewprep.blind75.week2;

import com.javadroider.interviewprep.util.ListNode;

public class _0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next;
        ListNode prev = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

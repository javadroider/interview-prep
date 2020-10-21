package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.ListNode;

public class _0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

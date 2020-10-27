package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.ListNode;

public class _0203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;

        }

        return dummy.next;
    }
}

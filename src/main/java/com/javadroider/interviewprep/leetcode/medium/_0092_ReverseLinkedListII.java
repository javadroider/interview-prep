package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;

public class _0092_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        /*
            Input: 1->2->3->4->5->NULL, m = 2, n = 4
            Output: 1->4->3->2->5->NULL
         */

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        int count = 1;

        while (count < m) {
            count++;
            prev = head;
            head = head.next;
        }

        ListNode prevHead = prev;
        ListNode current = head;
        ListNode next = null;
        count = n - m;
        while (current != null && count >= 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }
        prevHead.next = prev;
        head.next = next;
        return dummy.next;
    }

}

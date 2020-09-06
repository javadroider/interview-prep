package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;

public class _0002_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            head = head.next;
        }

        if (carry >= 1) {
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

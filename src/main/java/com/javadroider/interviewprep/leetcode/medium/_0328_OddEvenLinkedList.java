package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;

public class _0328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        //1->2->3->4->5->NULL
        if (head == null || head.next == null) {
            return head;
        }

        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}

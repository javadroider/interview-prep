package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.ListNode;

public class _0141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return false;
        }

        ListNode sp = head;
        ListNode fp = head;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                return true;
            }
        }

        return false;
    }
}

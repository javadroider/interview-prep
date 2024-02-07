package com.javadroider.interviewprep.blind75.week2;

import com.javadroider.interviewprep.util.ListNode;

import java.util.List;

public class _0141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode sp = head;
        ListNode fp = head;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (sp == fp) {
                return true;
            }
        }
        return false;
    }

}

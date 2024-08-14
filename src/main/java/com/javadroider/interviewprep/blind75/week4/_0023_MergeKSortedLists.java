package com.javadroider.interviewprep.blind75.week4;

import com.javadroider.interviewprep.util.ListNode;

import java.util.PriorityQueue;

public class _0023_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));

        for (ListNode list : lists) {
            pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}

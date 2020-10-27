package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.ListNode;

public class _0160_IntersectionOfTwoLinkedLists {

    //https://leetcode.com/problems/intersection-of-two-linked-lists/solution/160115
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }

        return pa;
    }
}

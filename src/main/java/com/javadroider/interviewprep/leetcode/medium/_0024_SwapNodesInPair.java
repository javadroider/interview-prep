package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;

public class _0024_SwapNodesInPair {

    public static void main(String[] args) {
        ListNode list = ListNode.getSampleLinkedList();
        _0024_SwapNodesInPair instance = new _0024_SwapNodesInPair();
        ListNode.print(instance.swapPairsIterative2(list));
    }

    //not working. Karumanchi
    public void swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return;
        } else {
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            swapPairsRecursive(head.next);
        }
    }

    //not working. Karumanchi
    public void swapPairs1(ListNode head) {
        ListNode temp = null, temp2 = null, current = head;
        while (current != null && current.next != null) {
            temp = current.next;
            temp2 = temp.next;
            temp.next = current;
            current.next = temp2;
            if (current != null) {
                current = current.next;
            }
        }
    }

    //working
    public ListNode swapPairs3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs3(third);
        return second;
    }

    //working
    public ListNode swapPairsIterative1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsIterative2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newhead = new ListNode(-1);//dummy
        newhead.next = head;
        ListNode temp = newhead;

        ListNode one = null;
        ListNode two = null;

        // {dummy->1->2->3->4->null}
        //explanation for one loop rest are same.

        while (temp.next != null && temp.next.next != null) {
            // temp points to dummy in the beginning.
            // one -> 1
            one = temp.next;
            //two -> 2
            two = temp.next.next;
            // 1-> = 2.next = 3;
            one.next = two.next;
            // 2-> = 1
            two.next = one;
            //now dummy should point to 2
            //if the below is not done dummy->1;
            temp.next = two;
            // temp was pointing to dummy
            //temp->1
            temp = one;

            // now { dummy->2->1->3->4 }

        }
        return newhead.next;
    }

    //not working
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = null;
        while (current != null && current.next != null) {
            next = current.next;
            current.next = next.next;
            next.next = current;
            current = current.next;
        }

        return head;
    }
}

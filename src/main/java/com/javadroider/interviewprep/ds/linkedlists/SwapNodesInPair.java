package com.javadroider.interviewprep.ds.linkedlists;

import com.javadroider.interviewprep.util.ListNode;

import java.util.List;

public class SwapNodesInPair {

    public static void main(String[] args) {
        ListNode list = ListNode.getSampleLinkedList();
        SwapNodesInPair instance = new SwapNodesInPair();
        ;
        ListNode.print(instance.swapPairs2(list));
    }


    public void swapPairsRecursive(ListNode head) {
        if(head == null || head.next == null){
            return;
        }else {
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            swapPairsRecursive(head.next);
        }
    }

    //working
    public ListNode swapPairs3(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }

    public ListNode swapPairs2(ListNode head) {
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

    public void swapPairs1(ListNode head) {
        ListNode temp = null, temp2 = null, current = head;
        while(current!= null && current.next!=null){
            temp = current.next;
            temp2 = temp.next;
            temp.next = current;
            current.next = temp2;
            if(current!=null){
                current = current.next;
            }
        }
    }

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

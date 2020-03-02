package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.ListNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode.print(new RemoveLinkedListElements().removeElements(ListNode.getSampleLinkedList(), 1));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(1);
        start.next = head;
        ListNode curr = head, prev = start;
        // 1, 2, 3, 4
        while(curr!=null){
            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }else {
                prev = curr;
                curr = curr.next;
            }
        }
        return start.next;
    }

    public ListNode removeElements1(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.val == val) {
                return null;
            } else {
                return head;
            }
        }
        ListNode prev = head;
        ListNode ret = head;
        head = head.next;
        //1, 2, 3, 4
        while (head != null) {
            if(head.val == val){
                prev.next = head.next;
            }else{
                prev = head;
            }
            head = head.next;
        }
        return ret;
    }
}

package com.javadroider.interviewprep.leetcode.easy;


import com.javadroider.interviewprep.util.ListNode;

import java.util.List;

public class LinkedListCycle2 {
    public static void main(String[] args) {
        System.out.println(new LinkedListCycle2().detectCycle(ListNode.getSampleLinkedListWithCycle()));
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while(fast != null && fast.next != null){
            if(slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
    public ListNode detectCycle1(ListNode head) {

        boolean cycleFound = false;

        if(head == null){
            return head;
        }

        ListNode sp = head, fp = head;

        while(sp != null && fp != null){
            fp = fp.next;
            if(fp == sp){
                cycleFound = true;
                break;
            }

            if(fp == null){
                break;
            }

            fp = fp.next;
            if( fp == sp){
                cycleFound = true;
                break;
            }
            sp = sp.next;

        }

        if(cycleFound){
            sp = head;
            while(fp!=sp){
                sp = sp.next;
                fp = fp.next;
            }
            return sp;
        }
        return null;
    }
}

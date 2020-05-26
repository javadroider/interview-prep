package com.javadroider.interviewprep.leetcode.easy;

import com.javadroider.interviewprep.util.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        System.out.println(new PalindromeLinkedList().isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null){
            return true;
        }

        ListNode sp = head;
        ListNode fp = head;

        while(fp != null && fp.next != null){
            fp = fp.next.next;
            sp = sp.next;
        }


        ListNode reverse = reverse(sp);
        ListNode current = head;
        while(current != null && reverse != null){
            if(current.val != reverse.val){
                return false;
            }
            current = current.next;
            reverse = reverse.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        if(null == head){
            return head;
        }

        ListNode temp = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = temp;
            temp = current;
            current = next;
        }

        return temp;
    }
}

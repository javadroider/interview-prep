package com.javadroider.interviewprep.leetcode.hard;

import com.javadroider.interviewprep.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _0023_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getSampleLinkedList();
        ListNode l2 = ListNode.getSampleLinkedList();
        ListNode l3 = ListNode.getSampleLinkedList();
        List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        ListNode.print(new _0023_MergeKSortedLists().mergeKLists(list));
    }

    //https://leetcode.com/problems/merge-k-sorted-lists/solution/
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), (o1,o2) -> Integer.compare(o1.val, o2.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            head = head.next;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(true){
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null){
                    if(lists[i].val <= min){
                        min = lists[i].val;
                        index = i;
                    }
                    isBreak = false;
                }
            }

            if(isBreak){
                break;
            }

            head.next = lists[index];
            lists[index] = lists[index].next;
            head = head.next;
        }

        return dummy.next;
    }
}

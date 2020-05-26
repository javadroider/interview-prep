package com.javadroider.interviewprep.ds.linkedlists;

import com.javadroider.interviewprep.util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getSampleLinkedList();
        ListNode l2 = ListNode.getSampleLinkedList();
        ListNode l3 = ListNode.getSampleLinkedList();
        List<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        ListNode.print(new MergeKSortedLists().mergeKLists(list));
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                }
                return 0;
            }
        });

        for (ListNode list : lists) {
            if(list!=null) {
                pq.add(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            head.next = node;
            if(node.next!=null){
                pq.add(node.next);
            }
            head = head.next;
        }

        return dummy.next;
    }
}

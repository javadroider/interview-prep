/**
 *
 */
package com.javadroider.interviewprep.ds.linkedlists;

import com.javadroider.interviewprep.util.LinkedList;
import com.javadroider.interviewprep.util.Node;

public class MergeSortedLinkedList {

	static Node mergeLists(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		Node head;
		if (list1.data < list2.data) {
			head = list1;
		} else {
			head = list2;
			list2 = list1;
			list1 = head;
		}
		while (list1.next != null) {
			if (list1.next.data > list2.data) {
				Node tmp = list1.next;
				list1.next = list2;
				list2 = tmp;
			}
			list1 = list1.next;
		}
		if (list1.next == null)
			list1.next = list2;
		return head;
	}

	static Node recursiveMergeLists(Node list1, Node list2) {
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  if (list1.data < list2.data) {
		    list1.next = recursiveMergeLists(list1.next, list2);
		    return list1;
		  } else {
		    list2.next = recursiveMergeLists(list2.next, list1);
		    return list2;
		  }
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(5);
		l1.add(7);


		LinkedList l2 = new LinkedList();
		l2.add(3);
		l2.add(4);
		//l2.add(8);

		l1.print();
		l2.print();

		Node head = recursiveMergeLists(l1.getHead(), l2.getHead());
		LinkedList.print(head);
	}

}

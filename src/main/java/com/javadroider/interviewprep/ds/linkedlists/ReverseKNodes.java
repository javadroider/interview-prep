/**
 *
 */
package com.javadroider.interviewprep.ds.linkedlists;

import com.javadroider.interviewprep.util.LinkedList;
import com.javadroider.interviewprep.util.Node;

public class ReverseKNodes {

	static Node recursiveReverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting from current. And make rest of the list as next of first node
		 */
		if (next != null)
			head.next = recursiveReverse(next, k);

		// prev is now head of input list
		return prev;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList l = LinkedList.getFilledLinkedList();
		l.print();
		Node head = recursiveReverse(l.getHead(), 3);
		LinkedList.print(head);
	}

}

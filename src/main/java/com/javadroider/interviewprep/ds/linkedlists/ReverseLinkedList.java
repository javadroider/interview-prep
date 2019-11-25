/**
 *
 */
package com.javadroider.interviewprep.ds.linkedlists;

import com.javadroider.interviewprep.util.LinkedList;
import com.javadroider.interviewprep.util.Node;

/**
 * 1->2->3->4
 */
public class ReverseLinkedList {

	public Node iterativeReverse(Node node) {

		Node next, prev = null;
		Node current = node;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public Node recursiveReverse(Node node) {
		if (node.next == null) {
			return node;
		}

		Node ret = recursiveReverse(node.next);
		Node next = node.next;
		next.next = node;
		node.next = null;
		return ret;

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList ll = LinkedList.getFilledLinkedList();
		ll.print();
		ReverseLinkedList instance = new ReverseLinkedList();
		Node head = instance.iterativeReverse(ll.getHead());
		ll.print(head);

		Node head2 = instance.recursiveReverse(head);
		ll.print(head2);

	}

}

package com.javadroider.interviewprep.ds.linkedlists;

import com.javadroider.interviewprep.util.LinkedList;
import com.javadroider.interviewprep.util.Node;

public class NthFromLastNode {

	private static Node getNthNodeFromLast(Node header, int n) {

		if (header == null) {
			return null;
		}

		Node node1 = header, node2 = header;
		int counter = 0;
		while (node1 != null) {
			if (counter == n) {
				break;
			}
			counter++;
			node1 = node1.next;
		}

//		for (int i = 0; i < n; i++) {
//			node1 = node1.next;
//		}

		while (node1 != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node2;
	}

	public static void main(String[] args) {

		LinkedList ll = LinkedList.getFilledLinkedList();
		ll.print();

		System.out.println(getNthNodeFromLast(ll.getHead(), 3));

	}
}

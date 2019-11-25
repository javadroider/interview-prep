package com.javadroider.interviewprep.util;

public class LinkedList {

	Node header;

	public void add(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (header == null) {
			header = node;
		} else {

			Node temp = header;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public Node getHead() {
		return header;
	}

	public void print() {
		StringBuffer sb = new StringBuffer();
		Node temp = header;
		boolean first = true;
		while (temp != null) {
			if (!first) {
				sb.append("->");
			}
			sb.append(temp.data);
			first = false;
			temp = temp.next;
		}
		System.out.println(sb.toString());
	}

	public static void print(Node head) {
		StringBuffer sb = new StringBuffer();
		Node temp = head;
		boolean first = true;
		while (temp != null) {
			if (!first) {
				sb.append("->");
			}
			sb.append(temp.data);
			first = false;
			temp = temp.next;
		}
		System.out.println(sb.toString());		
	}
	
	public static LinkedList getFilledLinkedList(){
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		return ll;
	}
}

package com.javadroider.interviewprep.ds.arrays;

import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

	public static void main(String[] args) {
//		int arr[] = { 11, 13, 21, 3 };
		int arr[] = { 4, 5, 2, 25 };
		int n = arr.length;
		printNGE(arr, n);
	}

	private static void printNGE(int[] a, int n) {
		Stack<Integer> stack = new Stack<>();
		stack.push(a[0]);
		for (int i = 1; i < n; i++) {

			int next = a[i];
			if (!stack.empty()) {
				int ele = stack.pop();
				while (next > ele) {
					System.out.println(ele + " - " + next);
					if (stack.empty()) {
						break;
					}
					ele = stack.pop();
				}
				if (ele > next) {
					stack.push(ele);
				}
			}
			stack.push(next);

		}
		while (!stack.empty()) {
			int ele = stack.pop();
			int next = -1;
			System.out.println(ele + " - " + next);
		}
	}

}

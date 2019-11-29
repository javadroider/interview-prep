package com.javadroider.interviewprep.ds.arrays;

import java.util.Arrays;
import java.util.Stack;

class StockSpanProblem {
	// method to calculate stock span values
	static void calculateSpan(int price[], int n, int S[]) {
		// Span value of first day is always 1
		S[0] = 1;

		// { 10, 4, 5, 90, 120, 80 }
		// Calculate span value of remaining days by linearly checking
		// previous days
		for (int i = 1; i < n; i++) {
			S[i] = 1; // Initialize span value

			// Traverse left while the next element on left is smaller
			// than price[i]
			for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
				S[i]++;
//			for (int j = i - 1; j >= 0; j--) {
//				if (price[i] >= price[j]) {
//					S[i]++;
//				}
//			}
		}
	}

	// A stack based efficient method to calculate
	// stock span values
	static void calculateSpanUsingStack(int price[], int n, int S[]) {
		// Create a stack and push index of first element
		// to it
		Stack<Integer> st = new Stack<>();
		st.push(0);

		// Span value of first element is always 1
		S[0] = 1;

		// Calculate span values for rest of the elements
		for (int i = 1; i < n; i++) {

			// Pop elements from stack while stack is not
			// empty and top of stack is smaller than
			// price[i]
			while (!st.empty() && price[st.peek()] <= price[i])
				st.pop();

			// If stack becomes empty, then price[i] is
			// greater than all elements on left of it, i.e.,
			// price[0], price[1], ..price[i-1]. Else price[i]
			// is greater than elements after top of stack
			S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

			// Push this element to stack
			st.push(i);
		}
	}

	// A utility function to print elements of array
	static void printArray(int arr[]) {
		System.out.print(Arrays.toString(arr));
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		// int price[] = { 10, 4, 5, 90, 120, 80 };
		int price[] = { 1, 2, 1 };
		int n = price.length;
		int S[] = new int[n];

		// Fill the span values in array S[]
		// calculateSpanUsingStack(price, n, S);
		calculateSpan(price, n, S);
		// print the calculated span values
		printArray(S);
	}
}

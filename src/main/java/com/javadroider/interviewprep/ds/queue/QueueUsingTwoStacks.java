package com.javadroider.interviewprep.ds.queue;

import java.util.Stack;

//https://www.geeksforgeeks.org/queue-using-stacks/
public class QueueUsingTwoStacks {

	static class DequeuHeavy {
		Stack<Integer> stack1;
		Stack<Integer> stack2;

		/* Function to push an item to stack */
		void push(Stack<Integer> stack, int new_data) {
			// Push the data onto the stack
			stack.push(new_data);
		}

		/* Function to pop an item from stack */
		int pop(Stack<Integer> stack) {
			/* If stack is empty then error */
			if (stack.isEmpty()) {
				System.out.println("Stack Underflow");
				System.exit(0);
			}

			// pop the data from the stack
			return stack.pop();
		}

		// Function to enqueue an item to the queue
		void enQueue(Queue q, int x) {
			push(stack1, x);
		}

		/* Function to deQueue an item from queue */
		int deQueue(Queue q) {
			int x;

			/* If both stacks are empty then error */
			if (stack1.isEmpty() && stack2.isEmpty()) {
				System.out.println("Q is empty");
				System.exit(0);
			}

			/*
			 * Move elements from stack1 to stack 2 only if stack2 is empty
			 */
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					x = pop(stack1);
					push(stack2, x);
				}
			}
			x = pop(stack2);
			return x;
		}
	}

	static class EnqueueHeavy {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		void enQueue(int x) {
			// Move all elements from s1 to s2
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}

			// Push item into s1
			s1.push(x);

			// Push everything back to s1
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
				// s2.pop();
			}
		}

		// Dequeue an item from the queue
		int deQueue() {
			// if first stack is empty
			if (s1.isEmpty()) {
				System.out.println("Q is Empty");
				System.exit(0);
			}

			// Return top of s1
			int x = s1.peek();
			s1.pop();
			return x;
		}
	}

}

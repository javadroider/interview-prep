package com.javadroider.interviewprep.leetcode.medium;

import java.util.PriorityQueue;

public class _0215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
        System.out.println(new _0215_KthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 2));
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}

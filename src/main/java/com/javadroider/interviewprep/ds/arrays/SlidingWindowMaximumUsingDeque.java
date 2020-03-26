package com.javadroider.interviewprep.ds.arrays;

import java.util.Deque;
import java.util.LinkedList;

//https://algorithms.tutorialhorizon.com/sliding-window-algorithm-track-the-maximum-of-each-subarray-of-size-k/
public class SlidingWindowMaximumUsingDeque {

    public void slidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        // Step 1: handle first k elements in sliding window
        for (int i = 0; i < k; i++) {
            // remove all the elements which are smaller than the current elements
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();
            // add new element at the end
            deque.addLast(i);
        }

        // Step 2: handle rest of the element, one at a time nums[k] to nums[n-1]
        for (int i = k; i < nums.length; i++) {

            // before we do anything, print the first element in deque
            // since its a maximum among previous k elements
            System.out.print(nums[deque.peekFirst()] + " ");

            // Now remove the elements which are out for next window (next k elements)
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            // Add the next element in the window = index i
            // remove all the elements which are smaller than the next element = index i
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();
            // add new element at the end
            deque.addLast(i);
        }
        // to print the last max element
        System.out.print(nums[deque.peekFirst()] + " ");
    }

    public void mySolution(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        //{1, 2, 3, 2, 4, 1, 5, 6, 1} k = 3
        //{0, 1, 2, 3, 4, 5, 6, 7, 8}
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[i] >= deque.getFirst()) {
                deque.removeFirst();
            }
            deque.addLast(i);
        }

        // 2(3),
        for (int i = k; i < nums.length; i++) {
            System.out.print(nums[deque.peekFirst()] + " ");
            // i = 3 k = 3
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[i] >= deque.getFirst()){
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        System.out.print(nums[deque.peekFirst()]);


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1, 5, 6, 1};
        int k = 3;
        SlidingWindowMaximumUsingDeque s = new SlidingWindowMaximumUsingDeque();
        s.slidingWindow(nums, k);
        System.out.println();
        s.mySolution(nums,k);
    }
}
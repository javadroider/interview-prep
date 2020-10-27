package com.javadroider.interviewprep.leetcode.easy;

import java.util.PriorityQueue;

public class _0703_KthLargestElementInAStream {


    class KthLargest {

        //https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/149050/Java-Priority-Queue/170563
        private PriorityQueue<Integer> pq = new PriorityQueue<>();
        private int k = 0;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0347_TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(new _0347_TopKFrequentElements().topKFrequent(nums, k)));
    }

    //https://leetcode.com/problems/top-k-frequent-elements/solution/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(map.get(n1), map.get(n2)));

        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.poll();
        }

        return res;
    }
}

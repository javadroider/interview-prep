package com.javadroider.interviewprep.blind75.week3;

import java.util.*;

public class _0347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2) -> frequencyMap.get(k1) - frequencyMap.get(k2));

        for (int key : frequencyMap.keySet()) {
            pq.offer(frequencyMap.get(key));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }

        return res;
    }
}

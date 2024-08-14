package com.javadroider.interviewprep.blind75.week3;

import java.util.*;

public class _0347_TopKFrequentElements {


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(new _0347_TopKFrequentElements().topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : frequencyMap.keySet()) {
            int count = frequencyMap.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    res[index++] = n;
                    if(index == k){
                        return res;
                    }
                }
            }
        }

        return res;




        /*
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : frequencyMap.keySet()) {
            int value = frequencyMap.get(key);
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        int[] res = new int[k];
        List<Integer> resList = new ArrayList<>();
        for (int i = bucket.length - 1; k > 0 && i >= 0; i--) {
            if (bucket[i] != null) {
                resList.addAll(bucket[i]);
                k--;
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
         */
    }

    public int[] topKFrequent1(int[] nums, int k) {

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

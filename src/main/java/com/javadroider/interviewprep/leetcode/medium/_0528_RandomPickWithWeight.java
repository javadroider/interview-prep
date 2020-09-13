package com.javadroider.interviewprep.leetcode.medium;

import java.util.Random;
import java.util.TreeMap;

public class _0528_RandomPickWithWeight {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(5, 5);
        //System.out.println(map.ceilingKey(3));
        //System.out.println(map.higherKey(3));

        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    //https://leetcode.com/problems/random-pick-with-weight/solution/
    static class Solution {
        private int[] prefixSums;
        private int totalSum;

        public Solution(int[] w) {
            this.prefixSums = new int[w.length];

            int prefixSum = 0;
            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                this.prefixSums[i] = prefixSum;
            }
            this.totalSum = prefixSum;
        }

        public int pickIndex() {
            double target = this.totalSum * Math.random();//important

            // run a binary search to find the target zone
            int low = 0, high = this.prefixSums.length;
            while (low < high) {
                // better to avoid the overflow
                int mid = low + (high - low) / 2;
                if (target > this.prefixSums[mid])
                    low = mid + 1;
                else
                    high = mid;
            }
            return low;
        }
    }

    //https://leetcode.com/problems/random-pick-with-weight/discuss/154024/JAVA-8-lines-TreeMap
    static class Solution1 {

        int[] arr;
        int max = 0;
        Random random = new Random();
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public Solution1(int[] w) {
            for (int i = 0; i < w.length; i++) {
                max += w[i];
                map.put(max, i);
                //[1,2,3] -> 1:0, 3:1, 6:2
            }
        }

        public int pickIndex() {
            int key = map.higherKey(random.nextInt(max));
            return map.get(key);
        }

    }

}

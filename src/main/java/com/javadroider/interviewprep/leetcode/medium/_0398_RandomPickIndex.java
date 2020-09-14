package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0398_RandomPickIndex {

    class Solution {

        private Map<Integer, List<Integer>> map = null;
        private Random random = null;

        //https://leetcode.com/problems/random-pick-index/discuss/813837/Java-using-HashMap
        public Solution(int[] nums) {
            map = new HashMap<>();
            random = new Random();
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indices = map.get(target);
            int index = random.nextInt(indices.size());
            return indices.get(index);
        }
    }
}

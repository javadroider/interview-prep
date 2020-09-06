package com.javadroider.interviewprep.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(diff, i);
            }
        }

        return new int[]{};
    }
}

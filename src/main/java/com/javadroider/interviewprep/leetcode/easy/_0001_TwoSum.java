package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _0001_TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new _0001_TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum1(int[] nums, int target) {
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

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int lo = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int hi = nums.length - 1;
            lo = i + 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo <= hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return result;
    }
}

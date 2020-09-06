package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0015_ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSumWithSorting(nums));
    }

    //https://leetcode.com/problems/3sum/solution/
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSumWithSorting(int[] nums) {
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

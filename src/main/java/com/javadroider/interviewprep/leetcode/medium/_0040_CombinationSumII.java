package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_CombinationSumII {

    //https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int nums[], List<Integer> temp, int remain, int start) {

        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(res, nums, temp, remain - nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

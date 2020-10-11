package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0039_CombinationSum {
    //https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null) {
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int remainSum, int start) {
        if (remainSum < 0) {
            return;
        }
        if (remainSum == 0) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, nums, temp, remainSum - nums[i], i);// not i + 1 because we can reuse same elements
            temp.remove(temp.size() - 1);
        }
    }
}

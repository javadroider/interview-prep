package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        System.out.println(new Subsets2().subsetsWithDup1(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack1(List<List<Integer>> res, int[] nums, List<Integer> temp, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack1(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}


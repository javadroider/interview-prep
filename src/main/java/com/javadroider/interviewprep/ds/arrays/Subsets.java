package com.javadroider.interviewprep.ds.arrays;

import java.util.*;

//https://www.educative.io/courses/grokking-the-coding-interview/gx2OqlvEnWG
class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    //https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[]{1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[]{1, 2, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = new Subsets().subsets(new int[]{1, 2, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}

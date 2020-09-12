package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i = 0; i< nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }

        return res;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        if(nums == null){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums,new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int start){

        res.add(new ArrayList<>(temp));

        for(int i = start; i< nums.length; i++){
            temp.add(nums[i]);
            backtrack(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}

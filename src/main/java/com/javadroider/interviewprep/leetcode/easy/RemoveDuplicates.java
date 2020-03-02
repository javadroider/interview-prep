package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int [] nums = {};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));
    }

    private static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        int prev = nums[0];
        int curr = 0;
        int uniqueIndex = 0;
        for (int i = 1; i < len; i++) {
            curr = nums[i];
            if (prev != curr) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
            prev = curr;
        }
        return uniqueIndex + 1;
    }
}

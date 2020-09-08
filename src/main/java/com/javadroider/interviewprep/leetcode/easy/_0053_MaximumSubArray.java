package com.javadroider.interviewprep.leetcode.easy;

public class _0053_MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; ++i) {
            maxEndingHere += nums[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

        }
        return maxSoFar;
    }
}

package com.javadroider.interviewprep.leetcode.easy;

public class _0724_FindPivotIndex {

    //https://leetcode.com/problems/find-pivot-index/solution/
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - leftSum - nums[i] == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

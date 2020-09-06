package com.javadroider.interviewprep.leetcode.easy;

public class _27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int uniqueIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        return uniqueIndex;
    }
}

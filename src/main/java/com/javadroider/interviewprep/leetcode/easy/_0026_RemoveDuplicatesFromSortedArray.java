package com.javadroider.interviewprep.leetcode.easy;

public class _0026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new _0026_RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}

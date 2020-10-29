package com.javadroider.interviewprep.leetcode.easy;

public class _0026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new _0026_RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }

    //0,0,1,1,1,2,2,3,3,4
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

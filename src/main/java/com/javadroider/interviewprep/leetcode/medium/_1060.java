package com.javadroider.interviewprep.leetcode.medium;

public class _1060 {


    public static void main(String[] args) {
        int[] nums = {4,7,9,10};
        int k = 1;
        System.out.println(new _1060().missingElement(nums, k));
    }

    public int missingElement(int[] nums, int k) {

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            int start = nums[i - 1];
            int end = nums[i];
            while (end - start > 1) {
                index++;
                if (index == k) {
                    return start + 1;
                }
                start++;
            }
        }
        return -1;
    }

}

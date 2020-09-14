package com.javadroider.interviewprep.leetcode.medium;

public class _0162_Find_Peak_Element {

    public static void main(String[] args) {
        System.out.println(new _0162_Find_Peak_Element().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }


    public int findPeakElement(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = mid1 + 1;

            if (nums[mid1] < nums[mid2]) {
                lo = mid2;
            } else {
                hi = mid1;
            }
        }
        return lo;
    }
}

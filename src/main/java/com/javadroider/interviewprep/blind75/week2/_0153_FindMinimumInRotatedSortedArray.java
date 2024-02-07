package com.javadroider.interviewprep.blind75.week2;

public class _0153_FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new _0153_FindMinimumInRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new _0153_FindMinimumInRotatedSortedArray().findMin(new int[]{6, 7, 8, 0, 2, 4, 5}));
    }

    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[lo] <= nums[hi]) {
                min = Math.min(min, nums[lo]);
                break;
            }
            min = Math.min(min, nums[mid]);
            if (nums[lo] <= nums[mid]) {
                min = Math.min(min, nums[lo]);
                lo = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                hi = mid - 1;
            }
        }
        return min;
    }
}

package com.javadroider.interviewprep.leetcode.medium;

public class _0034_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = bs(nums, target, true);
        if (start < 0) {
            return new int[]{-1, -1};
        }
        int end = bs(nums, target, false);
        return new int[]{start, end};
    }

    private int bs(int[] nums, int target, boolean left) {
        /*
            5,7,7,8,8,10
            0 1 2 3 4 5
            mid = (0 + 5)/2 = 2
            8 > 7
            lo = 3
            mid = 3 + 5 = 4
            8 > 8
            idx = 4
            hi = 3
            mid = 3 + 3 = 3
            8 == 8
            lo = 3 - 1 = 2

            ----
            mid = (0 + 5)/2 = 2
            8 >7
            lo = 2 + 1 = 3, hi = 5
            mid = 3 + 5 / 2 = 4
            8 > 8
            8 == 8
            lo = 5, hi = 5

            mid = 3 + 5 = 4
            8 > 8
            idx = 4
            lo = 5
            hi = 5
            8 > 10
            hi = 5 - 1 = 4

        */

        int idx = -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                idx = mid;
                if (left) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return idx;
    }

}

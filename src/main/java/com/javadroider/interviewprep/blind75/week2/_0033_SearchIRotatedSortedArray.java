package com.javadroider.interviewprep.blind75.week2;

import com.javadroider.interviewprep.leetcode.medium._0033_SearchInRotatedSortedArray;

public class _0033_SearchIRotatedSortedArray {

    public static void main(String[] args) {
        //System.out.println(new SearchInRotatedArray().search(new int[]{5, 6, 7, 8, 0, 1, 2, 3}, 7));
        //System.out.println(new SearchInRotatedArray().search(new int[]{5, 1, 3}, 5));
        //System.out.println(new SearchInRotatedArray().search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 8));
        System.out.println(new _0033_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3}, 2));
    }


    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        int lo = 0;
        int hi = nums.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (target <= nums[lo] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}

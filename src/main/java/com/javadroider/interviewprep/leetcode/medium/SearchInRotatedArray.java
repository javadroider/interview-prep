package com.javadroider.interviewprep.leetcode.medium;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        //System.out.println(new SearchInRotatedArray().search(new int[]{5, 6, 7, 8, 0, 1, 2, 3}, 7));
        //System.out.println(new SearchInRotatedArray().search(new int[]{5, 1, 3}, 5));
        //System.out.println(new SearchInRotatedArray().search(new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5}, 8));
        System.out.println(new SearchInRotatedArray().search(new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3}, 2));

        /**
         *
         * 6,7,8,0,1,2,3,4,5
         * 2,3,4,5,6,7,8,0,1
         * 4,5,6,7,8,0,1,2,3
         *
         */
    }

    public int search(int[] nums, int target) {
        /**
          0 1 2 3 4 5 6 7 8
         [4,5,6,7,8,0,1,2,3] target = 0
         lo = 0;
         hi = 8;
         mid = ((8-0)+0)/2 = 4

         **/

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target <= nums[mid]) {
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

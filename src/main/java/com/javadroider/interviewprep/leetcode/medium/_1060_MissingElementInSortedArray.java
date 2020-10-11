package com.javadroider.interviewprep.leetcode.medium;


public class _1060_MissingElementInSortedArray {

    /*
        Input: A = [4,7,9,10], K = 1
        Output: 5
        Explanation:
        The first missing number is 5.

        Input: A = [4,7,9,10], K = 3
        Output: 8
        Explanation:
        The missing numbers are [5,6,8,...], hence the third missing number is 8.

        Input: A = [1,2,4], K = 3
        Output: 6
        Explanation:
        The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
     */

    public static void main(String[] args) {
        //int[] nums = {4, 7, 9, 10};
        int[] nums = {1, 2, 4};
        int k = 3;
        System.out.println(new _1060_MissingElementInSortedArray().missingElement(nums, k));
    }

    //https://leetcode.com/problems/missing-element-in-sorted-array/solution/

    // Return how many numbers are missing until nums[idx]
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than
        // the last element of the array
        if (k > missing(n - 1, nums))
            return nums[n - 1] + k - missing(n - 1, nums);

        int left = 0, right = n - 1, pivot;
        // find left = right index such that
        // missing(left - 1) < k <= missing(left)
        while (left != right) {
            pivot = left + (right - left) / 2;

            if (missing(pivot, nums) < k) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        // kth missing number is greater than nums[idx - 1]
        // and less than nums[idx]
        return nums[left - 1] + k - missing(left - 1, nums);
    }

    //https://leetcode.com/problems/missing-element-in-sorted-array/solution/598011
    public int missingElementInEfficient(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1] - 1;
            if (k <= diff) {
                return nums[i - 1] + k;
            }
            k -= diff;
        }
        //1,2,4 -> k = 3 ==> 6
        return nums[nums.length - 1] + k;
    }


}

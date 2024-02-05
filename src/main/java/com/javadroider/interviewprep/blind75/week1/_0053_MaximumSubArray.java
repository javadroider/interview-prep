package com.javadroider.interviewprep.blind75.week1;

public class _0053_MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(new _0053_MaximumSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new _0053_MaximumSubArray().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    /*

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tempSum = 0;
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            if (tempSum > max) {
                max = tempSum;
                end = i;
            }
            if (tempSum < 0) {
                start = i + 1;
                tempSum = 0;
            }
        }

        System.out.println(start + " to " + end);
        return max;
    }
}

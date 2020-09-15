package com.javadroider.interviewprep.leetcode.easy;

public class _0053_MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; ++i) {
            maxEndingHere += nums[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

        }
        return maxSoFar;
    }

    private void withIndices(){
        int a[] = new int[] { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2 };
        int maxSoFar = a[0];
        int maxEndingHere = 0;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < a.length; i++) {
            maxEndingHere = maxEndingHere + a[i];
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }

            if (maxEndingHere < 0) {
                s = i + 1;
                maxEndingHere = 0;
            }
        }

        System.out.println("Max : " + maxSoFar);
        System.out.println("Start : " + start + ", End : " + end);
    }
}

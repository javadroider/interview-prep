package com.javadroider.interviewprep.blind75.week1;

import java.util.Arrays;

public class _0238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(new _0238_ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})).forEach(e -> System.out.print(e + " "));
    }

    /*
    Input: nums = [1,2,3,4]
    1, 1, 2, 6
          8, 6

    Output: [24,12,8,6]
     */
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }
}
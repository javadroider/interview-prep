package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}))
                .forEach(ele -> System.out.print(ele + " "));
    }

    public int[] productExceptSelf(int[] nums) {

        // 1, 2, 3, 4
        int res[] = new int[nums.length];
        int left = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = right * res[i];
            right = right * nums[i];
        }
        return res;
    }
}

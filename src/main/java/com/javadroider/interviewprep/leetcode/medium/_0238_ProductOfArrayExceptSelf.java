package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;

public class _0238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(new _0238_ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}))
                .forEach(ele -> System.out.print(ele + " "));
    }

    //https://www.youtube.com/watch?v=gREVHiZjXeQ
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            product = product * nums[i];
            res[i] = product;
        }

        product = 1;
        for(int i = nums.length - 1; i > 0; i--){
            res[i] = res[i-1] * product;
            product = product*nums[i];
        }

        res[0] = product;

        return res;
    }

    public int[] productExceptSelf1(int[] nums) {

        // 1, 2, 3, 4
        int res[] = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = product;
            product = product * nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = product * res[i];
            product = product * nums[i];
        }
        return res;
    }
}

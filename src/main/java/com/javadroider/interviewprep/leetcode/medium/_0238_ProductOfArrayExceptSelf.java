package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;

public class _0238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Arrays.stream(new _0238_ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}))
                .forEach(ele -> System.out.print(ele + " "));
    }

    /*

        nums -> [ 1  2  3  4  ]
        left -> [ 1  2  6  24 ]
        right > [ 24 24 12 4  ]
        op   -> [ 24 1*12 2*4 6]
        op[0] = right[i + 1] = right[1]
        op[n-1] = left[n-2]
        op[i] = left[i-1] * right[i+1]

     */

    //https://www.youtube.com/watch?v=gREVHiZjXeQ
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            res[i] = product;
        }

        product = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * product;
            product = product * nums[i];
        }

        res[0] = product;

        return res;
    }

}

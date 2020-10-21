package com.javadroider.interviewprep.ds.arrays;

class _0268_MissingNumber {

    //https://leetcode.com/problems/missing-number/solution/
    public static int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        //int arr[] = {13, 12, 11, 15};
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(arr));

    }
}
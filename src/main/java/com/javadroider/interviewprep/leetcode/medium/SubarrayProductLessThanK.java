package com.javadroider.interviewprep.leetcode.medium;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        String str = "11";
        StringBuffer sb = new StringBuffer();
        sb.insert(0,1);
        System.out.println(str.charAt(0) - '0');
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = 0;
        int end = nums.length;
        int product = 1;

        while (right < end) {

            product = product * nums[right];

            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            result += right - left + 1;
            right++;
        }

        return result;
    }
}

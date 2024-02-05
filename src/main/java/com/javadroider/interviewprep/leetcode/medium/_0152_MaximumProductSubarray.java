package com.javadroider.interviewprep.leetcode.medium;

public class _0152_MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(new _0152_MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
    }

    public int maxProduct(int[] nums) {
        int l = 1, r = 1;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;
            l = l * nums[i];
            r = r * nums[nums.length - 1 - i];
            ans = Math.max(ans, Math.max(l, r));
        }
        return ans;
    }
}

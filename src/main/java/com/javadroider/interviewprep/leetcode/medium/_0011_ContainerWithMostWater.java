package com.javadroider.interviewprep.leetcode.medium;

public class _0011_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (lo < hi) {
            int min = Math.min(height[hi], height[lo]);
            max = Math.max(max, min * (hi - lo));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }

        }
        return max;
    }
}

package com.javadroider.interviewprep.blind75.week2;

public class _0011_ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(new _0011_ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1, max = Integer.MIN_VALUE;

        while (i < j) {
            int water = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, water);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}

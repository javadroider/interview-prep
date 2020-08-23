package com.javadroider.interviewprep.leetcode.hard;

public class _42 {

    public static void main(String[] args) {
        System.out.println(new _42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
    public int trap(int[] height) {

        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}

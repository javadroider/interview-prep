package com.javadroider.interviewprep.leetcode.easy;

public class _0070_ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;
        int ret = 0;

        for (int i = 3; i <= n; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }

        return ret;
    }
}

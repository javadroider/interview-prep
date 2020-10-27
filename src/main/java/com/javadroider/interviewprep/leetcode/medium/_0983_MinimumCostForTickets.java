package com.javadroider.interviewprep.leetcode.medium;

public class _0983_MinimumCostForTickets {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(new _0983_MinimumCostForTickets().mincostTickets(days, costs));
    }

    //https://www.youtube.com/watch?v=MWJ7lwy1HF4
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return dp(days, costs, dp, 0);
    }

    private int dp(int[] days, int[] costs, int[] dp, int index) {

        if (index >= days.length) {
            return 0;
        }

        if (dp[index] > 0) {
            return dp[index];
        }

        int c1 = costs[0] + dp(days, costs, dp, index + 1);
        int k = index;

        for (; k < days.length; k++) {
            if (days[k] >= days[index] + 7) {
                break;
            }
        }
        int c2 = costs[1] + dp(days, costs, dp, k);

        k = index;
        for (; k < days.length; k++) {
            if (days[k] >= days[index] + 30) {
                break;
            }
        }
        int c3 = costs[2] + dp(days, costs, dp, k);
        dp[index] = Math.min(c1, Math.min(c2, c3));
        return dp[index];
    }
}

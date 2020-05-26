package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null)
            return 0;

        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int amt = 1; amt < dp.length; amt++) {
                if (amt - coins[i] >= 0)
                    dp[amt] = Math.min(dp[amt], dp[amt - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
}

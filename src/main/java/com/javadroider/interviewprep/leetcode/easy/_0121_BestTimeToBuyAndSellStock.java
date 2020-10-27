package com.javadroider.interviewprep.leetcode.easy;

public class _0121_BestTimeToBuyAndSellStock {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}

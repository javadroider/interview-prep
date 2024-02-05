package com.javadroider.interviewprep.blind75.week1;

public class _0121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(new _0121_BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /*
        Input: prices = [7,1,5,3,6,4]
        Output: 5
     */
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            buyPrice = Math.min(price, buyPrice);
            profit = Math.max(profit, price - buyPrice);
        }

        return profit;
    }
}

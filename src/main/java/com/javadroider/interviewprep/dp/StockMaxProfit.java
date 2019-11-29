package com.javadroider.interviewprep.dp;

public class StockMaxProfit {

	public static void main(String[] args) {
		int a[] = new int[] { 7, 1, 5, 3, 6, 4 };
		// int a[] = new int[] { 1, 2, 3, 4, 5 };
		// int a[] = new int[] { 100, 180, 260, 310, 40, 535, 695 };
		System.out.println(maxProfit1(a));
		maxProfit2(a, a.length);
	}

	static void maxProfit2(int price[], int n) {
		
		//https://www.geeksforgeeks.org/stock-buy-sell/
		
		// Prices must be given for at least two days
		if (n == 1) {
			return;
		}

		// Traverse through given price array
		int i = 0;
		while (i < n - 1) {

			// Find Local Minima
			// Note that the limit is (n-2) as we are
			// comparing present element to the next element
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			// If we reached the end, break
			// as no further solution possible
			if (i == n - 1)
				break;

			// Store the index of minima
			int buy = i++;

			// Find Local Maxima
			// Note that the limit is (n-1) as we are
			// comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			// Store the index of maxima
			int sell = i - 1;
			System.out.println("Buy on day: " + buy + " Sell on day: " + sell);

		}
	}

	private static int maxProfit1(int prices[]) {

		// https://www.youtube.com/watch?v=AMiYIX6X6Rg
		int profit = 0;
		boolean isBought = false;
		int dayBought = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			if (!isBought) {

				if (prices[i + 1] > prices[i]) {
					isBought = true;
					dayBought = i;
				}

			} else {
				if (prices[i + 1] < prices[i]) {
					System.out.println("Buy on day: " + dayBought + " Sell on day: " + i);
					profit = profit + prices[i] - prices[dayBought];
					isBought = false;
				}
			}

		}

		if (isBought) {
			System.out.println("Buy on day: " + dayBought + " Sell on day: " + (prices.length - 1));
			profit = profit + prices[prices.length - 1] - prices[dayBought];
		}
		return profit;
	}

}

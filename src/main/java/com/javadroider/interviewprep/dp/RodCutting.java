package com.javadroider.interviewprep.dp;

/**
 * 
 * 
 * For explanation check 
 * 
 * https://youtu.be/zFe-SX7jzDs
 *
 */
public class RodCutting {

	public static void main(String[] args) {
		int price[] = new int[] { 0, 2, 5, 9, 6 };
		int pieceLength[] = new int[] { 0, 1, 2, 3, 4 };
		System.out.println("Maximum Obtainable Value is " + cutRod(price, pieceLength, 5));
	}

	static int cutRod(int price[], int[] pieceLength, int length) {

		int[][] t = new int[price.length][length+1];

		for (int i = 0; i < price.length; i++) {
			for (int j = 0; j <= length; j++) {
				if (i == 0) {
					t[0][j] = 0;
				} else if (j == 0) {
					t[i][0] = 0;
				} else if (i == 1) {
					t[i][j] = price[i] * j;
				} else if (pieceLength[i] > j) {
					t[i][j] = t[i - 1][j];
				} else {
					t[i][j] = Math.max(t[i - 1][j], price[i] + t[i][j - pieceLength[i]]);
				}
			}
		}
		return t[price.length-1][length];
	}
}

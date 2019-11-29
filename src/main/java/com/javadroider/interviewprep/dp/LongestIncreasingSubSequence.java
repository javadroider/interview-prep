/**
 * 
 */
package com.javadroider.interviewprep.dp;

public class LongestIncreasingSubSequence {

	public static int lis(int a[]) {

		int n = a.length;
		int len[] = new int[n];

		for (int i = 0; i < n; i++) {
			len[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && (len[j] + 1) > len[i]) {
					len[i] = len[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (len[i] > max) {
				max = len[i];
			}
		}
		return max;

	}

	public static void main(String[] args) {
		System.out.println(lis(new int[] { 9, 21, 23, 24, 1, 9, 7 }));
	}

}

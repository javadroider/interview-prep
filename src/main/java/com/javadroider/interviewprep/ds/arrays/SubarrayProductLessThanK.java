package com.javadroider.interviewprep.ds.arrays;

//https://algorithms.tutorialhorizon.com/count-and-print-all-subarrays-with-product-less-than-k/
public class SubarrayProductLessThanK {

	public int find(int[] arrA, int k) {

		int result = 0;
		int arrSize = arrA.length;
		// start point
		for (int startPoint = 0; startPoint < arrSize; startPoint++) {
			// group sizes
			for (int grps = startPoint; grps <= arrSize; grps++) {
				// if start point = 1 then
				// grp size = 1 , take 10
				// grp size = 2, take 10 4
				// grp size = 3, take 10 4 2 ans so on
				int product = 1;
				int noElements = 0;
				String tempSubArrrays = "";
				for (int j = startPoint; j < grps; j++) {
					tempSubArrrays += arrA[j] + " ";
					product *= arrA[j];
					noElements++;
				}
				if (product < k && noElements > 0) {
					System.out.print(tempSubArrrays);
					result++;
					System.out.println();
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		SubarrayProductLessThanK s = new SubarrayProductLessThanK();
		int[] nums = { 1,2,3 };
		int k = 5;
		System.out.println("Sub arrays has sum less than k=100 are: " + s.find(nums, k));
	}
}

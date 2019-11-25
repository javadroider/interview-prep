package com.javadroider.interviewprep.ds.arrays;

//https://algorithms.tutorialhorizon.com/print-all-subarrays-of-a-given-array/
public class PrintAllSubArrays {

	public void printSubArrays(int[] arrA) {

		int arrSize = arrA.length;
		// start point
		for (int startPoint = 0; startPoint < arrSize; startPoint++) {
			// group sizes
			for (int grps = startPoint; grps <= arrSize; grps++) {
				// if start point = 1 then
				// grp size = 1 , print 1
				// grp size = 2, print 1 2
				// grp size = 3, print 1 2 3 ans so on
				for (int j = startPoint; j < grps; j++) {
					System.out.print(arrA[j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		int[] arrA = { 1, 2, 3 };
		new PrintAllSubArrays().printSubArrays(arrA);
	}

}
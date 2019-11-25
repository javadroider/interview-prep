package com.javadroider.interviewprep.ds.bitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Check https://prose.io/#javadroider/interview-prep/edit/master/src/com/javadroider/ds/arrays/Subsets.java
public class PowerSet {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		System.out.println(getSubsetUsingBitMap(list));
		
		int set[] = {1 ,2, 3};
		printSubsets(set);
	}

	static void printSubsets(int set[])
	{
		//https://java2blog.com/find-subsets-set-power-set/
		int n = set.length;
 
		// Run a loop from 0 to 2^n
		for (int i = 0; i < (1<<n); i++)
		{
			System.out.print("{ ");
			int m = 1; // m is used to check set bit in binary representation.
			// Print current subset
			for (int j = 0; j < n; j++)
			{
				if ((i & m) > 0)
				{		
					System.out.print(set[j] + " ");
				}
				m = m << 1;
			}
			
			System.out.println("}");
		}
	}
	private static Set<Set<String>> getSubsetUsingBitMap(List<String> list) {

		//https://javabypatel.blogspot.com/2015/10/all-subsets-of-set-powerset.html
		
		Set<Set<String>> result = new HashSet<Set<String>>();

		int numOfSubsets = 1 << list.size(); // OR Math.pow(2, list.size())

		// For i from 0 to 7 in case of [a, b, c],
		// we will pick 0(0,0,0) and check each bits to see any bit is set,
		// If set then element at corresponding position in a given Set need to be
		// included in a subset.
		for (int i = 0; i < numOfSubsets; i++) {

			Set<String> subset = new HashSet<String>();

			// We will use this mask to check any bit is set in binary representation of
			// value i
			int mask = 1;

			for (int k = 0; k < list.size(); k++) {

				// If result is !=0 (or >0) then bit is set
				if ((mask & i) != 0) {

					// Include the corresponding element from a given set in a subset
					subset.add(list.get(k));
				}

				// Check next bit in i.
				mask = mask << 1;
			}

			// add all subsets in final result.
			result.add(subset);
		}
		return result;
	}

}

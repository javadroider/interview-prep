package com.javadroider.interviewprep.ds.sorting;

import java.util.Arrays;

/**

The selection sort algorithm sorts an array by repeatedly finding the minimum element
from unsorted part and putting it at the beginning.

 The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element from the unsorted subarray is picked
 and moved to the sorted subarray.

Following example explains the above steps:

arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 

**/

public class SelectionSort {

    public static void main(String[] args) {
        int array[] = {10, 8, 13, 6, 15, 1};
        int n = array.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        Arrays.stream(array).forEach(ele -> System.out.print(ele + " "));
    }
}

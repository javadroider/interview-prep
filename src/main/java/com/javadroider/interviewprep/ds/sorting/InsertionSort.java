package com.javadroider.interviewprep.ds.sorting;

import java.util.Arrays;

/**
 * 12, 11, 13, 5, 6
 * <p>
 * Let us loop for i = 1 (second element of the array) to 4 (last element of the array)
 * <p>
 * i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
 * 11, 12, 13, 5, 6
 * <p>
 * i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
 * 11, 12, 13, 5, 6
 * <p>
 * i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
 * 5, 11, 12, 13, 6
 * <p>
 * i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
 * 5, 6, 11, 12, 13
 **/

public class InsertionSort {

    public static void main1(String[] args) {
        int arr[] = {10, 8, 13, 6, 15, 1};
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
    }

    //https://www.youtube.com/watch?v=i-SKeOcBwko
    public static void main(String[] args) {
        int arr[] = {8, 6, 5, 7, 1};
        int n = arr.length;
        int hole = 0, value = 0;
        for (int i = 1; i < n; i++) {
            value = arr[i];
            hole = i;
            while (hole > 0 && arr[hole - 1] > value) {
                arr[hole] = arr[hole - 1];
                hole--;
            }
            arr[hole] = value;
        }
        Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
    }
}

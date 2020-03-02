package com.javadroider.interviewprep.ds.sorting;

import java.util.Arrays;

//https://www.interviewbit.com/tutorial/quicksort-algorithm/
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 2, 1};
        quickSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(ele -> System.out.print(ele + " "));
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int i = low - 1;
        int pivot = a[high];
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }
}

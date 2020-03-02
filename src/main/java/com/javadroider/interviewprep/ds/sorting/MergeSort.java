package com.javadroider.interviewprep.ds.sorting;

import java.util.Arrays;

//https://www.interviewbit.com/tutorial/merge-sort-algorithm/
public class MergeSort {

    public static void main(String[] args) {
        int a[] = {9, 7, 8, 3, 2, 1};
        mergeSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(ele -> System.out.print(ele + " "));
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int t[] = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                t[k] = a[i];
                k++;
                i++;
            } else {
                t[k] = a[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            t[k] = a[i];
            i++;
            k++;
        }
        while (j <= end) {
            t[k] = a[j];
            j++;
            k++;
        }

        for(i=start;i<=end;i++){
            a[i]=t[i-start];
        }
    }
}

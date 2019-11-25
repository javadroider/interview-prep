package com.javadroider.interviewprep.ds.sorting;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {

        int a[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = a.length;

        int array[] = {1, 2, 3, 4, 5, 6, 7, 9};
        int x = 0, y = 0;

       //option1(a, arr_size);
    }

    private static void option1(int[] a, int arr_size) {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }

        Arrays.stream(a).forEach(ele -> System.out.print(ele + " "));
    }
}

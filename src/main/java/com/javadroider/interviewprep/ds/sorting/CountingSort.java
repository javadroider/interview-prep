package com.javadroider.interviewprep.ds.sorting;

//https://www.hackerearth.com/practice/algorithms/sorting/counting-sort/tutorial/
public class CountingSort {
    public static void main(String[] args) {
        int a[] = {8, 3, 5, 6, 4};
        countingSort(a);
    }

    private static void countingSort(int[] a) {
        int max = findMax(a);
        int aux[] = new int[max + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            aux[a[i]]++;
        }

        for (int i = 0; i < aux.length; i++) {
            while (aux[i] > 0) {
                System.out.print(i + " ");
                aux[i]--;
            }
        }

    }

    private static int findMax(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}

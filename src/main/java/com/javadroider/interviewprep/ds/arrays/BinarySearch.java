package com.javadroider.interviewprep.ds.arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 23, 33, 36, 66, 98, 102, 125, 131};

        System.out.println(iterative(arr, 66));
        System.out.println(recursive(arr, 0, arr.length - 1, 66));

    }

    private static int recursive(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target > arr[mid]) {
            return recursive(arr, mid + 1, right, target);
        } else {
            return recursive(arr, left, mid - 1, target);
        }
    }

    private static int iterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }


}

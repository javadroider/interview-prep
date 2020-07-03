package com.javadroider.interviewprep.ds.arrays;

//https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/
public class FindThreeLargestNumbers {
    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 50, 23, 90};

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }

        System.out.println(first + " , " + second + " , " + third);
    }
}

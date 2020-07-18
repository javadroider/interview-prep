package com.javadroider.interviewprep;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        secondLargest(new int[]{10, 10, 10});
    }

    private static void secondLargest(int[] arr) {
        //3, 1, 2
        // first = 3
        // second = 1
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }
}

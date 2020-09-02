package com.javadroider.interviewprep.companies.dh;

import java.util.PriorityQueue;

public class MinElement {

    public static void main(String[] args) {
        // you can write to stdout for debugging purposes, e.g.
        //System.out.println("This is a debug message");
        //int min = minimum(new int[]{9,1,23,-4,10});
        //int min = minimum(null);
        //System.out.println(min);
        //secondMinimum(new int[]{9,1,23,-4,10});
        System.out.println(nThMinimum(new int[]{9, 1, 23, -4, 10}, 2));
    }

    private static int nThMinimum(int[] a, int n) {

        if (a == null || a.length < n) {
            throw new RuntimeException("Array is invalid");
        }

        //PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
        PriorityQueue<Integer> queue = new PriorityQueue<>(n);
        //1,9,23
        for (int i = 0; i < a.length; i++) {
            queue.offer(a[i]);
//            if (queue.size() > n) {
//                int ele = queue.poll();
//                System.out.println(ele);
//            }
        }

        return queue.peek();
    }

    private static int minimum(int[] a) {
        //[9,1,23,-4,10] -> -4
        //[] or null -> Exception
        if (a == null || a.length == 0) {
            throw new RuntimeException("Array is invalid");
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    private static void secondMinimum(int[] a) {
        //[9,1,23,-4,10] -> -4
        //[] or null -> Exception
        if (a == null || a.length < 2) {
            throw new RuntimeException("Array is invalid");
        }
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < firstMin) {
                secondMin = firstMin;
                firstMin = a[i];
            } else if (a[i] < secondMin) {
                secondMin = a[i];
            }
        }
        System.out.println(firstMin);
        System.out.println(secondMin);
    }

}

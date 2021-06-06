package com.javadroider.interviewprep;

import java.util.PriorityQueue;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        secondLargest(new int[]{10, 10, 10});
    }

    private static void secondLargest(int[] arr) {


        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        pq.add(8);
        pq.add(2);
        pq.add(6);
        pq.add(1);
        pq.add(9);
        pq.add(3);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

        System.out.println();
        String word = "Hello    world";
        int wordCount = 0;
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                flag = true;
            } else {
                if (flag) {
                    wordCount++;
                }
                flag = false;

            }
        }
        System.out.println(wordCount);
        wordCount = 0;
        boolean prevCharWasSpace = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                prevCharWasSpace = true;
            } else {
                if (prevCharWasSpace) wordCount++;
                prevCharWasSpace = false;

            }
        }
        System.out.println(wordCount);

    }
}

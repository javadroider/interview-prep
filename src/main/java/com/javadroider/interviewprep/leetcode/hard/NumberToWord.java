package com.javadroider.interviewprep.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class NumberToWord {

    public static void main(String[] args) {
        System.out.println(numberToWords(23));
    }

    private static void numberToWord(int num) {

        String words[] = {"One Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty"
                , "Twenty", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        int values[] = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < values.length; i++) {
            int rem = num % values[i];
            if (rem != 0) {
                
            }

        }

    }

    static int B = 1000000000;
    static int M = 1000000;
    static int T = 1000;
    static int H = 100;

    static Map<Integer, String> hund;
    static Map<Integer, String> teen;
    static Map<Integer, String> one;

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        hund = new HashMap<>();
        hund.put(9, "Ninety");
        hund.put(8, "Eighty");
        hund.put(7, "Seventy");
        hund.put(6, "Sixty");
        hund.put(5, "Fifty");
        hund.put(4, "Forty");
        hund.put(3, "Thirty");
        hund.put(2, "Twenty");

        teen = new HashMap<>();
        teen.put(19, "Nineteen");
        teen.put(18, "Eighteen");
        teen.put(17, "Seventeen");
        teen.put(16, "Sixteen");
        teen.put(15, "Fifteen");
        teen.put(14, "Fourteen");
        teen.put(13, "Thirteen");
        teen.put(12, "Twelve");
        teen.put(11, "Eleven");
        teen.put(10, "Ten");

        one = new HashMap<>();
        one.put(9, "Nine");
        one.put(8, "Eight");
        one.put(7, "Seven");
        one.put(6, "Six");
        one.put(5, "Five");
        one.put(4, "Four");
        one.put(3, "Three");
        one.put(2, "Two");
        one.put(1, "One");

        return convert(num).trim();
    }

    static String convert(int num) {
        String res = "";

        if (num >= B) {
            res = convert(num / B) + " Billion " + convert(num % B);
        } else if (num >= M) {
            res = convert(num / M) + " Million " + convert(num % M);
        } else if (num >= T) {
            res = convert(num / T) + " Thousand " + convert(num % T);
        } else if (num >= H) {
            res = convert(num / H) + " Hundred " + convert(num % H);
        } else if (num >= 20) {
            res = hund.get(num / 10) + " " + convert(num % 10);
        } else if (num >= 10) {
            res = teen.get(num);
        } else if (num > 0) {
            res = one.get(num);
        }

        return res.trim(); // there will be extra spaces
    }

    private static void numberToWord1(int num) {
        String words[] = {"One Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty"
                , "Twenty", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        int values[] = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                System.out.print(words[i] + " ");
                num = num - values[i];
            }
        }

    }
}

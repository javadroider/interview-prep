package com.javadroider.interviewprep.leetcode.hard;

public class _273 {
    public static void main(String[] args) {
        System.out.println(new _273().numberToWords(4321000));
    }

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    //https://leetcode.com/problems/integer-to-english-words/discuss/70625/My-clean-Java-solution-very-easy-to-understand
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";
        //1234
        while (num > 0) {
            int n = num % 1000;//234
            if (n != 0) {
                words = helper(n) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;//1
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        //234
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}

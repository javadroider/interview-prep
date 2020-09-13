package com.javadroider.interviewprep.leetcode.hard;

public class _0273_IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(new _0273_IntegerToEnglishWords().numberToWords(1234567891));
    }

    /*

    Approach 1: Divide and conquer

    Let's simplify the problem by representing it as a set of simple sub-problems.
    One could split the initial integer 1234567890 on the groups containing not more than
    three digits 1.234.567.890.
    That results in representation 1 Billion 234 Million 567 Thousand 890 and
    reduces the initial problem to how to convert 3-digit integer to English word.
    One could split further 234 -> 2 Hundred 34 into two sub-problems : convert 1-digit integer and convert 2-digit integer.
    The first one is trivial. The second one could be reduced to the first one for all 2-digit integers but
    the ones from 10 to 19 which should be considered separately.

     */
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

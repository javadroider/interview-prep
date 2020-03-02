package com.javadroider.interviewprep.leetcode.easy;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));

    }

    private static int reverse(int x) {

        int isNegative = 1;

        if (x < 0) {
            isNegative = -1;
        }

        int digit = 0;
        Long reversed = 0L;
        x = Math.abs(x);
        while (x != 0) {
            digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        reversed = reversed * isNegative;
        return reversed.intValue();
    }

}

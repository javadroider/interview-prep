package com.javadroider.interviewprep.leetcode.easy;

public class _0007_ReverseInteger {

    public int reverse(int x) {

        int isNegative = 1;

        if (x < 0) {
            isNegative = -1;
        }

        int digit = 0;
        Long reversed = 0l;
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

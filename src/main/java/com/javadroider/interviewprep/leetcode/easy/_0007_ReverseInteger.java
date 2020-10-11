package com.javadroider.interviewprep.leetcode.easy;

public class _0007_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new _0007_ReverseInteger().reverse(-123));
    }

    //https://leetcode.com/problems/reverse-integer/solution/
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public int reverseUsingLong(int x) {

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

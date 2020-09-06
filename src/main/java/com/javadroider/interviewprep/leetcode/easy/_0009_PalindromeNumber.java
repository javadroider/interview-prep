package com.javadroider.interviewprep.leetcode.easy;

public class _0009_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = 0;
        int originalNumber = x;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return originalNumber == rev;
    }

}

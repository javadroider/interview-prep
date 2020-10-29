package com.javadroider.interviewprep.leetcode.easy;

public class _0680_ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(new _0680_ValidPalindromeII().validPalindrome("abca"));
    }

    //https://leetcode.com/problems/valid-palindrome-ii/discuss/107714/Java-solution-isPalindrome
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isValidPalindrome(s, start + 1, end) || isValidPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean isValidPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

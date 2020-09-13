package com.javadroider.interviewprep.leetcode.easy;

public class _0125_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new _0125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

    //https://leetcode.com/problems/valid-palindrome/solution/
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }

        return true;

    }


    public boolean isPalindrome1(String s) {

        if (s == null || s.trim().length() == 0) {
            return true;
        }

        String trimmedString = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                trimmedString += c;
            }
        }
        trimmedString = trimmedString.toLowerCase();
        int low = 0;
        int high = trimmedString.length() - 1;

        while (low < high) {
            if (trimmedString.charAt(low) != trimmedString.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}

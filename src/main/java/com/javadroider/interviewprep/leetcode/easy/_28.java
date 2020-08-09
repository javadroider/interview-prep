package com.javadroider.interviewprep.leetcode.easy;

public class _28 {

    public static void main(String[] args) {
        //System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    //https://leetcode.com/problems/implement-strstr/discuss/12807/Elegant-Java-solution
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length() && haystack.charAt(i + j) == needle.charAt(j); j++) {
                if (needle.length() - 1 == j) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int hl = haystack.length();
        int nl = needle.length();
        if (nl == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < hl; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int k = i;
                while (k < hl && j < nl && haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                }
                if (j == nl) {
                    return i;
                }
                j = 0;
            }
        }
        return -1;
    }
}

package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0345_ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println(new _0345_ReverseVowelsOfAString().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while (lo < hi) {

            while (lo < hi && !set.contains(chars[lo])) {
                lo++;
            }
            while (lo < hi && !set.contains(chars[hi])) {
                hi--;
            }

            char temp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = temp;
            lo++;
            hi--;
        }
        return String.valueOf(chars);
    }
}

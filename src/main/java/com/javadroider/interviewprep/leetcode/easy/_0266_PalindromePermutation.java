package com.javadroider.interviewprep.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false

Example 2:

Input: "aab"
Output: true

Example 3:

Input: "carerac"
Output: true

 */
public class _0266_PalindromePermutation {

    //https://leetcode.com/problems/palindrome-permutation/solution/
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!set.add(ch)) {
                set.remove(ch);
            }
        }
        return set.size() <= 1;
    }
}

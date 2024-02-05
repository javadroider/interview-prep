package com.javadroider.interviewprep.blind75.week1;

public class _0242_ValidAnagram {

    public static void main(String[] args) {
        System.out.println(new _0242_ValidAnagram().isAnagram("anagra", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] sString = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sString[s.charAt(i) - 'a']++;
            sString[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < s.length(); i++) {
            if (sString[s.charAt(i) - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }
}

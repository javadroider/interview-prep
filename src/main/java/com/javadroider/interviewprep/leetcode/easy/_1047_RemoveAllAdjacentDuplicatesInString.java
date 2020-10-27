package com.javadroider.interviewprep.leetcode.easy;

public class _1047_RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == S.charAt(i)) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}

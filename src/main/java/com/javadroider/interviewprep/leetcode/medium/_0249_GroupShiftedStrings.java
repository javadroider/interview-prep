package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence:
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * <p>
 * Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong
 * to the same shifting sequence.
 * <p>
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class _0249_GroupShiftedStrings {

    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

    }

    //https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder key = new StringBuilder();

            for (int i = 1; i < str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i - 1);
                if(diff < 0){
                    diff += 26;
                }
                key.append(diff);
            }
            map.putIfAbsent(key.toString(), new LinkedList<>());
            map.get(key.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

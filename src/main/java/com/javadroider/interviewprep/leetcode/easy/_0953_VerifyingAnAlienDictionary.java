package com.javadroider.interviewprep.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _0953_VerifyingAnAlienDictionary {
    Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    private int compare(String w1, String w2) {

        int min = Math.min(w1.length(), w2.length());
        int index = 0;
        while (index < min) {
            int c1 = map.get(w1.charAt(index));
            int c2 = map.get(w2.charAt(index));
            if (c1 < c2) {
                return -1;
            } else if (c1 > c2) {
                return 1;
            }
            index++;
        }
        return w1.length() < w2.length() ? -1 : 1;
    }
}

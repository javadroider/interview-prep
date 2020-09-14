package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0438_FindAllAnagramsInAString {

    //https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    public static void main(String[] args) {
        //System.out.println(new _0438_FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new _0438_FindAllAnagramsInAString().findAnagrams("baa", "aa"));
        //System.out.println(new _0438_FindAllAnagramsInAString().findAnagrams("abcd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> reference = new HashMap<>(); //reference map for p

        for (char c : p.toCharArray()) {
            reference.put(c, reference.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>(); //map to cache the chars in sliding window
        int start = 0, end = 0, match = 0;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (reference.containsKey(c1)) {
                map.put(c1, map.getOrDefault(c1, 0) + 1);
                if (map.get(c1).equals(reference.get(c1))) {
                    match++;
                }
            }
            end++;
            while (match == reference.size()) {//cbaebabacd abc
                if (end - start == p.length()) {
                    ans.add(start);
                }

                char c2 = s.charAt(start);
                if (reference.containsKey(c2)) {
                    map.put(c2, map.get(c2) - 1);
                    if (map.get(c2) < reference.get(c2)) {
                        match--;
                    }
                }
                start++;
            }

        }
        return ans;
    }


}

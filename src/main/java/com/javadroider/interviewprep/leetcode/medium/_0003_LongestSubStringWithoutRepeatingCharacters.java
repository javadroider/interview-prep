package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0003_LongestSubStringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        System.out.println(new _0003_LongestSubStringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.offer(s.charAt(i));
            max = Math.max(max, queue.size());

        }
        return max;

    }
}

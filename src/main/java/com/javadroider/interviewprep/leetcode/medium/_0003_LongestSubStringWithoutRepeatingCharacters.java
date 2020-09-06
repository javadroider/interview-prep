package com.javadroider.interviewprep.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _0003_LongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
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

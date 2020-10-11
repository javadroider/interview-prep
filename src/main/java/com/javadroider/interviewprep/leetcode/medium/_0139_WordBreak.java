package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0139_WordBreak {

    public static void main(String[] args) {
        _0139_WordBreak instance = new _0139_WordBreak();
        //System.out.println(instance.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
        System.out.println(instance.wordBreakWithMemoization("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }

    //https://leetcode.com/problems/word-break/solution/
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    //https://leetcode.com/problems/word-break/solution/
    public boolean wordBreakBruteForce(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakWithMemoization(String s, List<String> wordDict) {
        return wordBreakWithMemoization(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean wordBreakWithMemoization(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakWithMemoization(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }
}

package com.javadroider.interviewprep.blind75.week2;

import java.util.HashMap;
import java.util.Map;

public class _0076_MinimumWindowSubstring {


    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
        System.out.println(minWindow1("aa", "aa"));
    }

    //https://leetcode.com/problems/minimum-window-substring/solutions/4673578/beats-97-users-c-java-python-javascript-explained/
    public static String minWindow(String s, String t) {
        /*
            1. Count the frequency table for `t` & store in `tmp`
            2. loop of moving `right` from 0 to end of of `s`:
                If substring is found which containing `t`:
                using while-loop compare 2 freq tables moving `left`
                update min window
            3. return min window if found  otherwise ""
         */

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            int count = tMap.getOrDefault(ch, 0);
            tMap.put(ch, count + 1);
        }

        int l = 0;
        int required = tMap.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            int count = windowCounts.getOrDefault(ch, 0);
            windowCounts.put(ch, count + 1);

            if (tMap.containsKey(ch) && tMap.get(ch).intValue() == windowCounts.get(ch).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                char lCh = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(lCh, windowCounts.get(lCh) - 1);
                if (tMap.containsKey(lCh) && windowCounts.get(lCh) < tMap.get(lCh)) {
                    formed--;
                }
                l++;
            }
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static String minWindow1(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = dictT.getOrDefault(c, 0);
            dictT.put(c, count + 1);
        }

        int required = dictT.size();
        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);

                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

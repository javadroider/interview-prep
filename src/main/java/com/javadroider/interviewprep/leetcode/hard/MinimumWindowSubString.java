package com.javadroider.interviewprep.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubString().minWindow("ABBAACDBCAB", "ABC"));
    }

    public String minWindow(String s, String t) {
        //Hash map to store the t string
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            //Get the current index position
            char c = t.charAt(i);
            //load it to the window hash table, Here the key is the character value and the value is
            //character count, if the character is already present get the value if not return and increment
            //with 1
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        // Required the count of the entries in the window hashtable
        int requiredWindowSize = window.size();
        //Create a result array with three value -1 to the length, 0 to the left and right index values
        int[] result = {-1, 0, 0};
        //current left index is 0 and right index is 0 and expected is the minimumWindow hashtable
        int left = 0, right = 0, currentWindowSize = 0;
        //This is the minimumwindow hash table
        Map<Character, Integer> minimumWindow = new HashMap<>();
        //if right index is less than the string length
        while (right < s.length()) {
            //Get the right index position value character
            char c = s.charAt(right);
            //add it to the minimumWindow hash table
            minimumWindow.put(c, minimumWindow.getOrDefault(c, 0) + 1);
            //If this character is present in the window hashtable then check whether the count is matching
            if (window.containsKey(c) && minimumWindow.get(c).intValue() == window.get(c).intValue()) {
                //if the count is matching then increment the expected value by 1
                currentWindowSize++;
            }
            // If left index is less than the right index and all the characters and their count in the window
            //hash table matches with the minimumWindow hash table then take a note of this substring
            while (left < right && currentWindowSize == requiredWindowSize) {
                if (result[0] == -1 || result[0] > (right - left) + 1) {
                    result[0] = (right - left) + 1;
                    result[1] = left;
                    result[2] = right;
                }
                //Now remove the left character from the substring and decrement the index value in the
                // minimumWindow hash table by 1
                c = s.charAt(left);
                minimumWindow.put(c, minimumWindow.get(c) - 1);
                //If the minimumWindow does not contain all the characters and their count after removal then
                //decrement the expected
                //here we need to use the .intValue function to avoid the caching issue during auto unboxing
                if (window.containsKey(c) && minimumWindow.get(c) < window.get(c)) {
                    currentWindowSize--;
                }
                //move the left index one step to right
                left++;
            }
            //move the right index one step right.
            right++;
        }
//If the no result then
        return result[0] == -1 ? null : s.substring(result[1], result[2] + 1);
    }

    public String minWindowWithoutComments(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        int requiredWindowSize = window.size();
        int[] result = {-1, 0, 0};
        int left = 0, right = 0, currentWindowSize = 0;
        Map<Character, Integer> minimumWindow = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            minimumWindow.put(c, minimumWindow.getOrDefault(c, 0) + 1);
            if (window.containsKey(c) && minimumWindow.get(c).intValue() == window.get(c).intValue()) {
                currentWindowSize++;
            }
            while (left < right && currentWindowSize == requiredWindowSize) {
                if (result[0] == -1 || result[0] > (right - left) + 1) {
                    result[0] = (right - left) + 1;
                    result[1] = left;
                    result[2] = right;
                }
                c = s.charAt(left);
                minimumWindow.put(c, minimumWindow.get(c) - 1);
                if (window.containsKey(c) && minimumWindow.get(c) < window.get(c)) {
                    currentWindowSize--;
                }
                left++;
            }
            right++;
        }
        return result[0] == -1 ? null : s.substring(result[1], result[2] + 1);
    }

    public String minWindow1(String s, String t) {
        int[] counts = new int[256];
        for (char c : t.toCharArray()) {
            counts[c]++;
        }

        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        while (end < s.length()) {
            if (counts[s.charAt(end)] > 0) {
                counter--;
            }

            counts[s.charAt(end)]--;
            end++;

            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                counts[s.charAt(start)]++;
                if (counts[s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minStart + minLen);
    }
}

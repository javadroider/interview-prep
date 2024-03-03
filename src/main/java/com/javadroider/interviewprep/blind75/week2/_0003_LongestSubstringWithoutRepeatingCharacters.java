package com.javadroider.interviewprep.blind75.week2;

import java.util.HashMap;
import java.util.Map;

public class _0003_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new _0003_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }

    /*
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                //left = Math.max(map.get(s.charAt(right)) + 1, left);
                //It will fail for string 'abba' if we don't take max
                left = map.get(s.charAt(right)) + 1;
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

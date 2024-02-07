package com.javadroider.interviewprep.blind75.week2;

public class _0424_LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(new _0424_LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
    }

    /*
    Input: s = "ABBABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.
     */
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int l = 0;
        int maxCount = Integer.MIN_VALUE;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(r) - 'A']);
            if ((r - l + 1 - maxCount) > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}

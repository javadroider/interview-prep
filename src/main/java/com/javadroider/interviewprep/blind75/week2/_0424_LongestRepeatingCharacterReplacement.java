package com.javadroider.interviewprep.blind75.week2;

public class _0424_LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        //System.out.println(new _0424_LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
        System.out.println(new _0424_LongestRepeatingCharacterReplacement().characterReplacement("AAACCCCDDBBA", 3));
    }

    /*
    Input: s = "ABBABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exists other ways to achieve this answer too.
     */
    public int characterReplacement1(String s, int k) {

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

    public int characterReplacement(String s, int k) {
        // Initialising an empty array to store the count of the
        // characters in the given string s
        int[] count = new int[26];
        int res = 0;
        int maxCount = 0;

        // The left pointer for the sliding window is l AND r is the
        // right pointer
        int l = 0;
        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);
            int c = s.charAt(r) - 'A';
            // Counting the number of each character in the string s
            count[c]++;

            // Checking the character with max number of occurrence
            maxCount = Math.max(maxCount, count[c]);

            // Now we check if our current window is valid or not
            if (r - l + 1 - maxCount > k) {
                // this means the no. of replacements is more than
                // allowed (k)
                // Decrementing the count of the character which was
                // at l because it is no longer in the window
                count[s.charAt(l) - 'A']--;
                l++;
            }

            // The max our window can be
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}


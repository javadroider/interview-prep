package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/*

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted.
More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.


Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.



 */
public class _0791_CustomSortString {

    //https://leetcode.com/problems/custom-sort-string/solution/
    /*

    Time Complexity: O(S.length+T.length)O(S.\text{length} + T.\text{length})O(S.length+T.length), the time it takes to iterate through S and T

    Space Complexity: O(T.length)O(T.\text{length})O(T.length). We count at most 26 different lowercase letters, but the final answer has the same length as T.

     */
    public String customSortString(String S, String T) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : T.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : S.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }

        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

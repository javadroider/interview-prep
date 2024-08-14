package com.javadroider.interviewprep.blind75.week4;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence {


    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    //https://leetcode.com/problems/longest-consecutive-sequence/solutions/4662555/o-n-solution-in-java/
    public static int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        Set<Integer> sequences = new HashSet();
        for (int num : nums) {
            sequences.add(num);
        }
        for (int num : nums) {
            int nextInSeq = num + 1;
            int prevInSeq = num - 1;
            int currentSequence = 1;
            while (sequences.remove(prevInSeq--)) {
                currentSequence++;
            }
            while (sequences.remove(nextInSeq++)) {
                currentSequence++;
            }
            if (currentSequence > maxSeq) {
                maxSeq = currentSequence;
            }
        }
        return maxSeq;
    }
}

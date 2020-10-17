package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;

public class _0435_NonOverlappingIntervals {

    //https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
}

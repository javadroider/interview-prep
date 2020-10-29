package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;

public class _0435_NonOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(new _0435_NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    //https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java:-Least-is-Most/96277
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    //https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
    public int eraseOverlapIntervalsDifficultToUnderstand(int[][] intervals) {
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

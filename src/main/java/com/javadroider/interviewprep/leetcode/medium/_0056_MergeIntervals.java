package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[] currentInterval = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(currentInterval);

        for (int[] interval : intervals) {
            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                currentInterval = interval;
                list.add(currentInterval);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}

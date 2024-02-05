package com.javadroider.interviewprep.blind75.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _0056_MergeIntervals {

    public static void main(String[] args) {
        System.out.println(new _0056_MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        Stream.of(new _0056_MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})).
                forEach(ele -> System.out.println(ele[0] + "," + ele[1]));
    }


    /*
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[] currentInterval = intervals[0];
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (currentInterval[1] >= interval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                list.add(interval);
                currentInterval = interval;
            }
        }

        return list.toArray(new int[list.size()][2]);

    }


}

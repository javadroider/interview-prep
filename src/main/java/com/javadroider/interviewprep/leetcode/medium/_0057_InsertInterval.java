package com.javadroider.interviewprep.leetcode.medium;

import java.util.LinkedList;

public class _0057_InsertInterval {

    public static void main(String[] args) {
        System.out.println();
        new _0057_InsertInterval().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
    }

    //https://leetcode.com/problems/insert-interval/solution/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        int n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();

        // add all intervals starting before newInterval
        while (idx < n && newStart > intervals[idx][0]) {
            output.add(intervals[idx++]);
        }

        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {// if there is an overlap, merge with the last interval
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0];
            int end = interval[1];
            // if there is no overlap, just add an interval
            if (output.getLast()[1] < start) {
                output.add(interval);
            }
            else {// if there is an overlap, merge with the last interval
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _0986_IntervalListIntersections {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/interval-list-intersections/discuss/231122/Java-two-pointers-O(m-%2B-n)
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        if (A.length == 0 || B.length == 0) {
            return new int[][]{};
        }

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < A.length && bIndex < B.length) {

            int start = Math.max(A[aIndex][0], B[bIndex][0]);
            int end = Math.min(A[aIndex][1], B[bIndex][1]);

            if (end >= start) {
                res.add(new int[]{start, end});
            }

            if (A[aIndex][1] == end) {
                aIndex++;
            }
            if (B[bIndex][1] == end) {
                bIndex++;
            }
        }
        return res.toArray(new int[res.size()][2]);

    }
}

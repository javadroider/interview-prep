package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _986 {

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

            int max = Math.max(A[aIndex][0], B[bIndex][0]);
            int min = Math.min(A[aIndex][1], B[bIndex][1]);

            if (min >= max) {
                res.add(new int[]{max, min});
            }

            if (A[aIndex][1] == min) {
                aIndex++;
            }
            if (B[bIndex][1] == min) {
                bIndex++;
            }
        }
        return res.toArray(new int[res.size()][2]);

    }
}

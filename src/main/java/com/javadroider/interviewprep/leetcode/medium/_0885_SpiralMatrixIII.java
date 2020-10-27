package com.javadroider.interviewprep.leetcode.medium;

public class _0885_SpiralMatrixIII {

    public static void main(String[] args) {

    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int idx = 0;
        int pathLength = 1;
        while (idx < R * C) {

            //right & down
            for (int i = 0; i < pathLength; i++) {
                if (add(res, idx, r0, c0++, R, C)) {
                    idx++;
                }
            }
            for (int i = 0; i < pathLength; i++) {
                if (add(res, idx, r0++, c0, R, C)) {
                    idx++;
                }
            }
            pathLength++;
            //left & up
            for (int i = 0; i < pathLength; i++) {
                if (add(res, idx, r0, c0--, R, C)) {
                    idx++;
                }
            }
            for (int i = 0; i < pathLength; i++) {
                if (add(res, idx, r0--, c0, R, C)) {
                    idx++;
                }
            }
            pathLength++;
        }

        return res;
    }

    private boolean add(int[][] res, int idx, int r, int c, int totalRows, int totalCols) {
        if (r < 0 || r >= totalRows || c < 0 || c >= totalCols) {
            return false;
        }

        res[idx][0] = r;
        res[idx][1] = c;

        return true;
    }
}

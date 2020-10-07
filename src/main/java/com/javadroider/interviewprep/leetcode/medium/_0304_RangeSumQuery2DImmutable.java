package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.Matrix;

public class _0304_RangeSumQuery2DImmutable {

    //https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75350/Clean-C%2B%2B-Solution-and-Explaination-O(mn)-space-with-O(1)-time
    public static void main(String[] args) {
        NumMatrix obj = new NumMatrix(Matrix.sample1());
        //System.out.println(obj.sumRegion());
    }

    static class NumMatrix {

        private int[][] res;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            res = new int[matrix.length + 1][matrix[0].length + 1];
            for (int r = 1; r <= matrix.length; r++) {
                for (int c = 1; c <= matrix[0].length; c++) {
                    res[r][c] = matrix[r - 1][c - 1] + res[r - 1][c] + res[r][c - 1] - res[r - 1][c - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            //sum
            return res[row2 + 1][col2 + 1] - res[row2 + 1][col1] - res[row1][col2 + 1] + res[row1][col1];
        }
    }

}

package com.javadroider.interviewprep.leetcode.medium;

public class _0311_SparseMatrixMultiplication {

    //https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76154/Easiest-JAVA-solution
    public int[][] multiply(int[][] A, int[][] B) {
        /*
            A = [
              [ 1, 0, 0],
              [-1, 0, 3]
            ]

            B = [
              [ 7, 0, 0 ],
              [ 0, 0, 0 ],
              [ 0, 0, 1 ]
            ]
                 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
            AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                              | 0 0 1 |
         */
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < nB; k++) {
                        if (B[j][k] != 0) C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return C;
    }
}

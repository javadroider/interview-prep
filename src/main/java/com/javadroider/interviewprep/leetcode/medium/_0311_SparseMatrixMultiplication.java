package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.Matrix;

public class _0311_SparseMatrixMultiplication {

    /*

        https://www.mathsisfun.com/algebra/matrix-multiplying.html
            A = [
              [ 1, 2, 3 ],
              [ 4, 5, 6 ]
            ]

            B = [
              [ 7, 8, 9 ],
              [ 1, 2, 3 ],
              [ 5, 6, 4 ]
            ]

            [1*7+2*1+3*5 1*8+2*2+3*6 1*9+2*3+3*4],
            [4*7+5*1+6*5 4*8+5*2+6*6 4*9+5*3+6*4]

            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    for(int k = 0; k < matrix[0].length; k++){
                        c[i][j] += A[i][k] * B[k][j];


     */
    public static void main(String[] args) {
        int[][] matrix = new _0311_SparseMatrixMultiplication().multiply(Matrix.sample2(), Matrix.sample3());
        Matrix.print(matrix);
        matrixMultiplication();
    }

    //https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76154/Easiest-JAVA-solution
    public int[][] multiply(int[][] A, int[][] B) {
        /*
           NOT DONE
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
                        if (B[j][k] != 0) {
                            C[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return C;
    }

    private static void matrixMultiplication() {
        int r1 = 2, c1 = 3;
        int r2 = 3, c2 = 2;

        /*
            A = [
              [ 1, 2, 3 ],
              [ 4, 5, 6 ]
            ]

            B = [
              [ 7, 8, 9 ],
              [ 1, 2, 3 ],
              [ 5, 6, 4 ]
            ]

            [1*7+2*1+3*5 1*8+2*2+3*6 1*9+2*3+3*4],
            [4*7+5*1+6*5 4*8+5*2+6*6 4*9+5*3+6*4]
         */
        int[][] firstMatrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] secondMatrix = {{7, 8, 9}, {1, 2, 3}, {5, 6, 4}};
        r1 = firstMatrix.length;
        c1 = firstMatrix[0].length;

        r2 = secondMatrix.length;
        c2 = secondMatrix[0].length;

        // Mutliplying Two matrices
        int[][] product = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    int first = firstMatrix[i][k];
                    int second = secondMatrix[k][j];
                    int prod = product[i][j];
                    product[i][k] += first * second;
                }
            }
        }

        // Displaying the result
        System.out.println("Sum of two matrices is: ");
        for (int[] row : product) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }
}

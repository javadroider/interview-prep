package com.javadroider.interviewprep.leetcode.medium;

public class _0073_SetMatrixZeroes {

    public static void main(String[] args) {

        //int[][] matrix = {{0, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] matrix = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        _0073_SetMatrixZeroes instance = new _0073_SetMatrixZeroes();
        instance.printMatrix(matrix);
        new _0073_SetMatrixZeroes().setZeroes(matrix);
        System.out.println();
        instance.printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Space: O(1)
     * credit: https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
     */
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        /**the first iteration (first nested for loop) is to check from top row to bottom row:
         * keep the first column state into variable col0;
         * then starting from the second column, check all the rest of the columns and mark its top cell and its most-left cell if it
         * s a zero.*/
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        /**the second iteration (second nested for loop) is to check from bottom row to the top row
         * from the right-most column to the second left-most column: as long as its left-most column cell or its top row cell is zero, then set that cell to be zero
         * at last, check col0 variable, if it's zero, mark that row cell as zero*/
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}

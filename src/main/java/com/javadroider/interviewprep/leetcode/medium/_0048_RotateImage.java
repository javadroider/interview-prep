package com.javadroider.interviewprep.leetcode.medium;

public class _0048_RotateImage {

    //https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        _0048_RotateImage instance = new _0048_RotateImage();
        instance.printMatrix(matrix);
        instance.rotate(matrix);
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

    //https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n / 2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}

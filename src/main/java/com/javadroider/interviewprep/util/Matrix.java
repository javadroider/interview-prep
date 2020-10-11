package com.javadroider.interviewprep.util;

public class Matrix {

    public static int[][] sample1() {
        return new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
    }

    public static int[][] sample2() {
        return new int[][]{{1, 0, 0}, {-1, 0, 3}};
    }

    public static int[][] sample3() {
        return new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
    }

    public static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}

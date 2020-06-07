package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int [][]{{7},{9},{6}}));
        //System.out.println(new SpiralMatrix().spiralOrder(new int[][]{{7, 9, 6}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int top = 0;
        int down = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length - 1;

        int direction = 0;

        while (top <= down && left <= right) {

            if (direction == 0) { // L -> R
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) { // TOP -> DOWN
                for (int i = top; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            } else if (direction == 2) {// RIGHT -> LEFT
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                down--;
            } else if (direction == 3) { // DOWN -> TOP
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }

        return res;
    }
}

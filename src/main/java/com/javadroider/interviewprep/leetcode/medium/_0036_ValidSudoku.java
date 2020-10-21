package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0036_ValidSudoku {

    //https://leetcode.com/problems/valid-sudoku/solution/
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] cols = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = (int) board[i][j];
                    int boxIndex = ((i / 3) * 3) + j / 3;

                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
                    boxes[boxIndex].put(num, boxes[boxIndex].getOrDefault(num, 0) + 1);

                    if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxes[boxIndex].get(num) > 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

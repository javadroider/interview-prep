package com.javadroider.interviewprep.leetcode.hard;

public class _37 {

    public static final int SIZE = 9;

    public void display(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main2(String[] args) {
        for (int i = 0; i < 9; i++) {
            //System.out.println(i + "%3 -> " + i % 3);
            System.out.println(i + "%3 -> " + i % 3 + " : " + i + "/3 -> " + i / 3);
            //int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3;

        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'9', '.', '.', '1', '.', '.', '.', '.', '5'},
                {'.', '.', '5', '.', '9', '.', '2', '.', '1'},
                {'8', '.', '.', '.', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '.', '.', '.', '.'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '2', '6', '.', '.', '9'},
                {'2', '.', '.', '3', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '.', '.', '9', '.', '.'},
                {'.', '.', '1', '9', '.', '4', '5', '7', '.'},
        };
        _37 instance = new _37();

        instance.display(board);
        instance.solveSudoku(board);
        instance.display(board);

    }

    //https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (valid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char num) {
        int rowBlock = 3 * (row / 3);
        int colBlock = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num || board[rowBlock + (i / 3)][colBlock + (i % 3)] == num) {
                return false;
            }
        }
        return true;
    }
}

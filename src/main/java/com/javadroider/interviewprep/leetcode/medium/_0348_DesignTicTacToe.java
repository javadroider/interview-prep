package com.javadroider.interviewprep.leetcode.medium;

public class _0348_DesignTicTacToe {

    //https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.print(ticTacToe.move(0, 0, 1));
        System.out.print(ticTacToe.move(0, 2, 2));
        System.out.print(ticTacToe.move(2, 2, 1));
        System.out.print(ticTacToe.move(1, 1, 2));
        System.out.print(ticTacToe.move(2, 0, 1));
        System.out.print(ticTacToe.move(1, 0, 2));
        System.out.print(ticTacToe.move(2, 1, 1));
    }

    static class TicTacToe {

        private int[] rows;
        private int[] cols;
        private int diagonal;
        private int antiDiagonal;


        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;
            int size = rows.length;
            rows[row] += toAdd;
            cols[col] += toAdd;

            if (row == col) {
                diagonal += toAdd;
            }

            if (row + col == size - 1) {
                antiDiagonal += toAdd;
            }

            if (Math.abs(rows[row]) == size ||
                    Math.abs(cols[col]) == size ||
                    Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
                return player;
            }

            return 0;
        }
    }

}

package com.javadroider.interviewprep.leetcode.medium;

public class CountBattleShips {
    public static void main(String[] args) {
        char [][] mat = {{'X','0','0','X'},{'0','0','0','X'},{'0','0','0','X'},{'0','0','0','X'}};
        System.out.println(new CountBattleShips().countBattleships(mat));
    }

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return 0;
        int ships = 0, m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    //check if we have encountered this ship before
                    if (i > 0 && board[i - 1][j] == 'X')
                        continue;
                    if (j > 0 && board[i][j - 1] == 'X')
                        continue;
                    ships++;
                }
            }
        }

        return ships;
    }
}

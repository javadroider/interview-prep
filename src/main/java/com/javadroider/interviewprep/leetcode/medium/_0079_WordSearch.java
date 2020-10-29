package com.javadroider.interviewprep.leetcode.medium;

public class _0079_WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int count) {
        if (count == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, word, i + 1, j, count + 1) || dfs(board, word, i - 1, j, count + 1) || dfs(board, word, i, j - 1, count + 1) || dfs(board, word, i, j + 1, count + 1);
        board[i][j] = temp;
        return found;

    }
}

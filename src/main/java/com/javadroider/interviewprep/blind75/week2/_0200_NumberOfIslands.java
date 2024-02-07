package com.javadroider.interviewprep.blind75.week2;

public class _0200_NumberOfIslands {

    public static void main(String[] args) {
        char[][] mat1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] mat2 = {{'1', '0', '0', '1'}, {'0', '1', '1', '0'}, {'0', '1', '1', '1'}, {'1', '0', '1', '1'}};
        System.out.println(new _0200_NumberOfIslands().numIslands(mat1));
        System.out.println(new _0200_NumberOfIslands().numIslands(mat2));

    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    traverse(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void traverse(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';

        traverse(grid, x - 1, y);
        traverse(grid, x + 1, y);
        traverse(grid, x, y - 1);
        traverse(grid, x, y + 1);
    }
}

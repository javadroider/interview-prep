package com.javadroider.interviewprep.blind75.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0417_PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        //https://leetcode.com/problems/pacific-atlantic-water-flow/solutions/90733/java-bfs-dfs-from-ocean/

        List<List<Integer>> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            dfs(matrix, pacific, 0, col, Integer.MIN_VALUE);
            dfs(matrix, atlantic, rows - 1, col, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rows; row++) {
            dfs(matrix, pacific, row, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, row, cols - 1, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(row);
                    res.add(col);
                    ans.add(res);
                }
            }
        }
        return ans;
    }


    private void dfs(int[][] matrix, boolean[][] visited, int r, int c, int prevHeight) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] || prevHeight > matrix[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(matrix, visited, r + 1, c, matrix[r][c]);
        dfs(matrix, visited, r - 1, c, matrix[r][c]);
        dfs(matrix, visited, r, c + 1, matrix[r][c]);
        dfs(matrix, visited, r, c - 1, matrix[r][c]);
    }
}

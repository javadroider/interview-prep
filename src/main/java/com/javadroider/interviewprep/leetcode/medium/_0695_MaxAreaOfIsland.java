package com.javadroider.interviewprep.leetcode.medium;

public class _0695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int ret = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i ,j, 0);
                    ret = Math.max(area, ret);
                }
            }
        }
        return ret;
    }

    private int dfs(int[][] grid, int i, int j, int area){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return area;
        }

        grid[i][j] = 0;
        area++;

        area = dfs(grid,i, j - 1, area);
        area = dfs(grid,i, j + 1, area);
        area = dfs(grid,i - 1, j, area);
        area = dfs(grid,i + 1, j, area);

        return area;
    }
}

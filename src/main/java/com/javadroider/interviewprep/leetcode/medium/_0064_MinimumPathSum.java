package com.javadroider.interviewprep.leetcode.medium;

public class _0064_MinimumPathSum {

    //https://leetcode.com/problems/minimum-path-sum/discuss/23477/DP-Solution-Linear-space/22808
    //https://leetcode.com/problems/minimum-path-sum/solution/
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}

package com.javadroider.interviewprep.leetcode.easy;

public class _0463_IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new _0463_IslandPerimeter().islandPerimeter(grid));
    }

    //https://www.youtube.com/watch?v=FkjFlNtTzc8
    public int islandPerimeter(int[][] grid) {

        if(grid == null){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    result += 4;

                    if(r > 0 && grid[r-1][c] == 1){
                        result -= 2;
                    }

                    if(c > 0 && grid[r][c - 1] == 1){
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}

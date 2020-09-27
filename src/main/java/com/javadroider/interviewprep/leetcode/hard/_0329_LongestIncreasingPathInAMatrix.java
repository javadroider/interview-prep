package com.javadroider.interviewprep.leetcode.hard;

import com.javadroider.interviewprep.util.Matrix;

public class _0329_LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        System.out.println(new _0329_LongestIncreasingPathInAMatrix().longestIncreasingPath(Matrix.sample1()));
    }

    //https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java-Solution/183009
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, cache, -1));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) {
            return 0;
        }

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int ret = 0;
        ret = Math.max(ret, dfs(matrix, i, j + 1, cache, matrix[i][j]));
        ret = Math.max(ret, dfs(matrix, i, j - 1, cache, matrix[i][j]));
        ret = Math.max(ret, dfs(matrix, i + 1, j, cache, matrix[i][j]));
        ret = Math.max(ret, dfs(matrix, i - 1, j, cache, matrix[i][j]));
        ret++;
        cache[i][j] = ret;

        return ret;
    }
}

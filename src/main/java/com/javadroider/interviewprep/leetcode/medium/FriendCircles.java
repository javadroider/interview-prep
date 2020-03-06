package com.javadroider.interviewprep.leetcode.medium;

public class FriendCircles {

    public static void main(String[] args) {
        int [][] mat = {{1,1},{0,0}};
        int [][] mat1 = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(new FriendCircles().findCircleNum(mat1));
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public int findCircleNum1(int[][] M) {

        int circles = 0;
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[i].length; j++){
                if(M[i][j] == 1){
                    circles++;
                    bfs(M, i, j);
                }
            }
        }

        return circles;
    }

    private void bfs(int grid[][], int row, int col){

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;

        //left
        bfs(grid, row, col - 1);
        //right
        bfs(grid, row, col + 1);
        //up
        bfs(grid, row + 1, col);
        //down
        bfs(grid, row - 1, col);

    }

    private void bfs1(int [][] M, int i, int j){
        if(i < 0 || i >= M.length  || j < 0 || j >= M[i].length || M[i][j] == '0'){
            return;
        }
        M[i][j] = 0;
        bfs(M, i + 1, j);
        bfs(M, i - 1, j);
        bfs(M, i, j + 1);
        bfs(M, i, j - 1);

    }
}

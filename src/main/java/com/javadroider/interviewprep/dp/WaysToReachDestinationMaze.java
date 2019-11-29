/**
 * 
 */
package com.javadroider.interviewprep.dp;

public class WaysToReachDestinationMaze {

	static int R = 4;
	static int C = 4;

	// Returns count of possible paths in
	// a maze[R][C] from (0,0) to (R-1,C-1)
	static int countPaths(int maze[][]) {
		// If the initial cell is blocked,
		// there is no way of moving anywhere
		if (maze[0][0] == -1)
			return 0;

		// Initializing the leftmost column
		for (int i = 0; i < R; i++) {
			if (maze[i][0] == 0)
				maze[i][0] = 1;

			// If we encounter a blocked cell
			// in leftmost row, there is no way
			// of visiting any cell directly below it.
			else
				break;
		}

		// Similarly initialize the topmost row
		for (int i = 1; i < C; i++) {
			if (maze[0][i] == 0)
				maze[0][i] = 1;

			// If we encounter a blocked cell in
			// bottommost row, there is no way of
			// visiting any cell directly below it.
			else
				break;
		}

		// The only difference is that if a cell
		// is -1, simply ignore it else recursively
		// compute count value maze[i][j]
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				// If blockage is found,
				// ignore this cell
				if (maze[i][j] == -1)
					continue;

				// If we can reach maze[i][j] from
				// maze[i-1][j] then increment count.
				if (maze[i - 1][j] > 0)
					maze[i][j] = (maze[i][j] + maze[i - 1][j]);

				// If we can reach maze[i][j] from
				// maze[i][j-1] then increment count.
				if (maze[i][j - 1] > 0)
					maze[i][j] = (maze[i][j] + maze[i][j - 1]);
			}
		}

		// If the final cell is blocked,
		// output 0, otherwise the answer
		return (maze[R - 1][C - 1] > 0) ? maze[R - 1][C - 1] : 0;
	}

	public static void main(String[] args) {
		int maze[][] = {{0, 0, 0, 0}, 
                		{0, -1, 0, 0}, 
                		{-1, 0, 0, 0}, 
                		{0, 0, 0, 0}}; 
		System.out.println(countPaths(maze)); 

	}

}

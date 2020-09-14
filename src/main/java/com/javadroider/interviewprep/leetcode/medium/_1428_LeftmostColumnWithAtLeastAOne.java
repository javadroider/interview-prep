package com.javadroider.interviewprep.leetcode.medium;

import java.util.List;

/**
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
 * <p>
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * <p>
 * Example 4:
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 */
public class _1428_LeftmostColumnWithAtLeastAOne {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/leftmost-column-with-at-least-a-one/solution/
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }

    //https://leetcode.com/problems/leftmost-column-with-at-least-a-one/discuss/590828/Java-Binary-Search-and-Linear-Solutions-with-Picture-Explain-Clean-Code
    public int leftMostColumnWithOneInEfficient(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int columns = dimensions.get(1);
        int left = 0;
        int right = columns - 1;
        int ret = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (binarySearch(binaryMatrix, rows, mid)) {
                ret = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

    private boolean binarySearch(BinaryMatrix binaryMatrix, int rows, int col) {
        for (int r = 0; r < rows; r++) {
            if (binaryMatrix.get(r, col) == 1) {
                return true;
            }
        }
        return false;
    }

    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions();
    }
}

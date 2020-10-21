package com.javadroider.interviewprep.leetcode.medium;

public class _0074_SearchA2DMatrix {

    //https://leetcode.com/problems/search-a-2d-matrix/solution/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0;
        int right = m * n - 1;
        int pivotIdx;
        int pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}

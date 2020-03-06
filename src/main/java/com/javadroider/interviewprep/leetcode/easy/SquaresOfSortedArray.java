package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    //-4,-1,0,3,10
    public int[] sortedSquares(int[] A) {
        //result array
        int[] res = new int[A.length];
        //pointers for left and right
        int lo = 0;
        int hi = A.length - 1;
        //iterate from n to 0
        for (int i = A.length - 1; i >= 0; i--) {
            //check if abs left is less than or equal to abs right
            if (Math.abs(A[lo]) >= Math.abs(A[hi])) {
                //add left squared to result array
                res[i] = A[lo] * A[lo];
                //increment left pointer
                lo++;
            } else {
                //add right squared to result array
                res[i] = A[hi] * A[hi];
                //decrement right pointer
                hi--;
            }
        }
        //result
        return res;
    }
}

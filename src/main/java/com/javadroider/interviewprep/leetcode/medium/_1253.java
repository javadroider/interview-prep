package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 */
public class _1253 {

    public static void main(String[] args) {
        int upper = 2;
        int lower = 1;
        int[] colsum = {1, 1, 1};

//        int upper = 5;
//        int lower = 5;
//        int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        reconstructMatrix(upper, lower, colsum);
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            int targetSum = colsum[i];
            if (targetSum == 2) {
                one.add(1);
                two.add(1);
                upper--;
                lower--;
            } else if (targetSum == 1) {
                if (upper > lower) {
                    one.add(1);
                    two.add(0);
                    upper--;
                } else {
                    two.add(1);
                    one.add(0);
                    lower--;
                }
            } else if (targetSum == 0) {
                one.add(0);
                two.add(0);
            }
        }
        if (upper != 0 || lower != 0) {
            return result;
        }
        result.add(one);
        result.add(two);
        System.out.println(one);
        System.out.println(two);
        System.out.println(Arrays.toString(colsum));
        return result;
    }
}

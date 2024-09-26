package com.javadroider.interviewprep.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _0118_PascalsTriangle {

    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {

            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);
            currRow.add(1);

            for (int j = 1; j < prevRow.size(); j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currRow.add(1);
            triangle.add(currRow);
        }


    }
}

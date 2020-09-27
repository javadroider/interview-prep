package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1424_DiagonalTraverseII {

    //https://leetcode.com/problems/diagonal-traverse-ii/discuss/597741/Clean-Simple-Easiest-Explanation-with-a-picture-and-code-with-comments
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int maxKey = 0;
        int size = 0;
        for (int r = 0; r < nums.size(); r++) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                int key = r + c;
                map.putIfAbsent(key, new LinkedList<>());
                map.get(key).addFirst(nums.get(r).get(c));
                size++;
                maxKey = Math.max(maxKey, key);
            }
        }

        int[] ret = new int[size];
        int index = 0;
        for (int sum = 0; sum <= maxKey; sum++) {
            for (int ele : map.get(sum)) {
                ret[index++] = ele;
            }
        }
        return ret;
    }
}

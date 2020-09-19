package com.javadroider.interviewprep.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class _0349_IntersectionOfTwoArrays {

    //https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> resSet = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                resSet.add(num);
            }
        }

        int[] ret = new int[resSet.size()];
        int index = 0;
        for (int num : resSet) {
            ret[index++] = num;
        }

        return ret;
    }
}

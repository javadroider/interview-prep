package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArrays {

    /**
     *
     *
     * [0]
     * 0
     * [1]
     * 1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        new MergeSortedArrays().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 > 0 && tail2 > 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 > 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }
}

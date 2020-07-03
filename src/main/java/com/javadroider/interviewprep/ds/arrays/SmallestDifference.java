package com.javadroider.interviewprep.ds.arrays;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 10, 20, 28};
        int[] nums2 = {15, 17, 26, 134, 135};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = 0;
        int n2 = 0;
        int diff = Integer.MAX_VALUE;
        int n1Idx = 0;
        int n2Idx = 0;
        while (n1 < nums1.length && n2 < nums2.length) {
            int temp = Math.abs(nums1[n1] - nums2[n2]);
            if (temp < diff) {
                n1Idx = n1;
                n2Idx = n2;
                diff = temp;
            }
            if (nums1[n1] < nums2[n2]) {
                n1++;
            } else if (nums1[n1] > nums2[n2]) {
                n2++;
            } else {
                n1++;
                n2++;
            }
        }

        System.out.println(nums1[n1Idx] + " " + nums2[n2Idx]);
    }
}

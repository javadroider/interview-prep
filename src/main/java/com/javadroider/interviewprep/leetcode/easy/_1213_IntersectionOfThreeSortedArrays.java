package com.javadroider.interviewprep.leetcode.easy;

import java.util.*;

/*

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of
only the integers that appeared in all three arrays.


Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.


 */
public class _1213_IntersectionOfThreeSortedArrays {

    public static void main(String[] args) {

        System.out.println(new _1213_IntersectionOfThreeSortedArrays().
                arraysIntersection(new int[]{1, 3, 5}, new int[]{2, 4, 5}, new int[]{3, 5, 6}));
        System.out.println(new _1213_IntersectionOfThreeSortedArrays().
                arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8}));
    }

    //https://leetcode.com/problems/intersection-of-three-sorted-arrays/discuss/397603/Simple-Java-solution-beats-100/357444
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();


        int a1 = 0, a2 = 0, a3 = 0;

        while (a1 < arr1.length && a2 < arr2.length && a3 < arr3.length) {
            int min = Math.min(arr1[a1], Math.min(arr2[a2], arr3[a3]));
            if (arr1[a1] == min && arr2[a2] == min && arr3[a3] == min) {
                res.add(min);
            }
            if(arr1[a1] == min){
                a1++;
            }
            if(arr2[a2] == min){
                a2++;
            }
            if(arr3[a3] == min){
                a3++;
            }
        }

        return res;
    }

    public List<Integer> arraysIntersectionMine(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();

        int a1 = 0, a2 = 0, a3 = 0;

        while (a1 < arr1.length && a2 < arr2.length && a3 < arr3.length) {
            if (arr1[a1] == arr2[a2] && arr2[a2] == arr3[a3]) {
                res.add(arr1[a1]);
                a1++;
                a2++;
                a3++;
            } else {
                if (arr1[a1] <= arr2[a2] && arr1[a1] <= arr3[a3]) {
                    a1++;
                } else if (arr2[a2] <= arr1[a1] && arr2[a2] <= arr3[a3]) {
                    a2++;
                } else {
                    a3++;
                }
            }
        }
        return res;
    }

    public List<Integer> arraysIntersectionBruteForce(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr3.length; k++) {
                    if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                        res.add(arr1[i]);
                    }
                }
            }
        }
        return res;
    }
}

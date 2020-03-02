package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {

    public static void main(String[] args) {
        int[] a = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(a, 2));
        Arrays.stream(a).forEach(ele -> System.out.print(ele + " "));
    }

    private static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int uniqueIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }

        return uniqueIndex;
    }
}

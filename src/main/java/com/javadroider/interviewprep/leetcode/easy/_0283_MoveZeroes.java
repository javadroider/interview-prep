package com.javadroider.interviewprep.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class _0283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 3};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(ele -> System.out.print(ele + " "));

    }

    private static void moveZeroes(int[] nums) {
        int len = nums.length;
        int uniqueIndex = 0;
        //0,1,2
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[uniqueIndex];
                nums[uniqueIndex] = temp;
                uniqueIndex++;
            }
        }
    }

    private static void moveZeroes2(int[] nums) {
        //1,0,2
        int len = nums.length;
        int uniqueIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }
        while (uniqueIndex < len) {
            nums[uniqueIndex++] = 0;
        }
    }

    private static void moveZeroes1(int[] nums) {
        int lo = 0;
        int len = nums.length;
        int high = len - 1;
        while (lo < high) {
            if (nums[lo] == 0) {
                int temp = nums[lo];
                nums[lo] = nums[high];
                nums[high] = temp;
                high--;
            } else {
                lo++;
            }
        }
    }
}

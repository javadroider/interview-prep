package com.javadroider.interviewprep.ds.arrays;

import java.util.Arrays;

public class MoveElementToEnd {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 2, 2, 2, 2, 2};

        int nonTwoIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 2) {
                int temp = nums[i];
                nums[i] = nums[nonTwoIndex];
                nums[nonTwoIndex] = temp;
                nonTwoIndex++;
            }
        }

        Arrays.stream(nums).forEach(ele -> System.out.print(ele +" "));
    }
}

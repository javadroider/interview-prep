package com.javadroider.interviewprep.ds.arrays;
public class SlidingWindowMaximumNaive {

    public void slidingWindow(int [] nums, int k){

        for (int i = 0; i <nums.length - k ; i++) {
            int max = nums[i];
            for (int j = 1; j<=k ; j++) {
                if(nums[i+j]>max)
                    max = nums[i+j];
            }
            System.out.print(max + " ");
        }
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 2, 4, 1, 5, 6, 1};
        int k = 3;
        SlidingWindowMaximumNaive s = new SlidingWindowMaximumNaive();
        s.slidingWindow(nums, k);
    }
}
package com.javadroider.interviewprep.leetcode.medium;

public class _0334_IncreasingTripletSubsequence {

    //https://leetcode.com/problems/increasing-triplet-subsequence/solution/
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= firstNum){
                firstNum = num;
            }else if(num <= secondNum){
                secondNum = num;
            }else{
                return true;
            }
        }

        return false;
    }
}

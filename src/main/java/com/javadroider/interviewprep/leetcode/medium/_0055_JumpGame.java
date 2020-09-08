package com.javadroider.interviewprep.leetcode.medium;

public class _0055_JumpGame {

    public boolean canJump(int[] nums) {
        //https://www.youtube.com/watch?v=muDPTDrpS28
        int n = nums.length;
        int reachable = 0;
        for(int i = 0; i < n; i++){
            if(i > reachable){
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}

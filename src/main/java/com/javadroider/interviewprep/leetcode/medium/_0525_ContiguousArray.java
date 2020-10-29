package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0525_ContiguousArray {

    /*

    In this approach, we make use of a count variable, which is used to store the relative number of ones and zeros
    encountered so far while traversing the array.
    The count variable is incremented by one for every 1 encountered and the same is decremented by one for every 0
    encountered.
    We start traversing the array from the beginning. If at any moment, the count becomes zero,
    it implies that we've encountered equal number of zeros and ones from the beginning till the current
    index of the array(i). Not only this, another point to be noted is that
    if we encounter the same count twice while traversing the array, it means that the number of zeros and ones
    are equal between the indices corresponding to the equal count values

     */
    //https://leetcode.com/problems/contiguous-array/solution
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}

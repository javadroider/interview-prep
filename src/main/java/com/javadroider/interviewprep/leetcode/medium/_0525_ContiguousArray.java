package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0525_ContiguousArray {

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

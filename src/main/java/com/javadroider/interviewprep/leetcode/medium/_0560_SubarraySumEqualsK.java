package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubarraySumEqualsK {

    //https://www.youtube.com/watch?v=HbbYPQc-Oo4
    //https://leetcode.com/problems/subarray-sum-equals-k/discuss/134689/Three-Approaches-With-Explanation
    public int subarraySum(int[] nums, int k) {
        /*
          k = 7
          3 4 7   2 -3 1  4  2
          3 7 14 16 13 14 18 20
          0  1
          3  1
          7  1 count = 1
          14 1 count = 2
          16 1
          13 1
          14 2 count = 3
          18 1
          20 1 count = 4
        */
        int sum = 0;
        int sumMinusK = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMinusK = sum - k;
            if (map.containsKey(sumMinusK)) {
                count += map.get(sumMinusK);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

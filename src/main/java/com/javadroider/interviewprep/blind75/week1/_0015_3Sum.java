package com.javadroider.interviewprep.blind75.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_3Sum {

    public static void main(String[] args) {
        System.out.println(new _0015_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new _0015_3Sum().threeSum(new int[]{0, 1, 1}));
        System.out.println(new _0015_3Sum().threeSum(new int[]{0, 0, 0}));
        System.out.println(new _0015_3Sum().threeSum(new int[]{-2, 0, 0, 2, 2}));
    }


    /*
    Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

}

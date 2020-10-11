package com.javadroider.interviewprep.leetcode.medium;

public class _1004_MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println(new _1004_MaxConsecutiveOnesIII().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    //https://leetcode.com/problems/max-consecutive-ones-iii/discuss/247543/O(n)-Java-Solution-using-sliding-window/363536
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int ret = 0;
        int zeroCount = 0;
        // A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) {
                zeroCount++;
            }
            if (zeroCount > K) {
                if (A[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            ret = Math.max(ret, end - start + 1);
        }

        return ret;
    }
}

package com.javadroider.interviewprep.leetcode.easy;

public class _0278_FirstBadVersion {


    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}

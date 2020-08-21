package com.javadroider.interviewprep.companies.dh;

public class MaxSum {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 4, 5, 1, 0};
        int k = 2;
        int left = 0;
        int right = 1;
        int end = a.length;
        int max = 0;
        int sum = 0;
        while (right <= end) {
            sum += a[right - 1];
            if ((right - left) < k) {
                right++;
            } else {
                max = Math.max(max, sum);
                sum -= a[left];
                left++;
                right++;
            }
        }
    }
}

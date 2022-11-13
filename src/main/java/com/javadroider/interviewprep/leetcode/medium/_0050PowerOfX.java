package com.javadroider.interviewprep.leetcode.medium;

public class _0050PowerOfX {

    //https://www.youtube.com/watch?v=wAyrtLAeWvI
    //https://leetcode.com/problems/powx-n/discuss/19544/5-different-choices-when-talk-with-interviewers
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        /*
            x^n = x^n/2 * x^n/2 = (x*x)^n/2 if n is even
            x^n = x* x^n-1 =
            n == 0 -> 1

            2^4 = 2 * 2 * 2 * 2 = 16

            myPow(2, 4) = myPow(4, 2) = 16
            myPow(4, 2) = myPow(16, 1) = 16
            MyPow(16, 1) = 16 * myPow(16 * 16, 0) = 16 * 1 = 16
            myPow(16 * 16, 0)  = 1
         */

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

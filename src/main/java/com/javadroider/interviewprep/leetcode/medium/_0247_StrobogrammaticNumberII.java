package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.

Example:
Input:  n = 2
Output: ["11","69","88","96"]

 */
public class _0247_StrobogrammaticNumberII {

    /*

    recursive add  00 11 88 69 96. add 00 only if not first and last of final string.
parameters are (sizeToBuild, initialSize)

n - 2 is the new size of the strings that you need to find. Initially it was n, then you find results for n - 2 and add two more characters one at the starting and one at the end of the strings of size n - 2 so total size of the strings in the result will be n.
m is just the given value of n and it stay also.
You can't add 0 at the starting or ending of the number that's why add 0 only if n != m i.e. you will later append more characters to this string


     */
    public List<String> findStrobogrammatic(int n) {
        return recursiveBuild(n, n);
    }

    List<String> recursiveBuild(int n, int m) {
        if (n == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = recursiveBuild(n - 2, m);

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}

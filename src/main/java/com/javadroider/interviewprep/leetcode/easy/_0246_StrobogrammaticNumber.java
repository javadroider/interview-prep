package com.javadroider.interviewprep.leetcode.easy;

import java.util.*;

/*

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:
Input: num = "69"
Output: true

Example 2:
Input: num = "88"
Output: true

Example 3:
Input: num = "962"
Output: false

Example 4:
Input: num = "1"
Output: true

 */
public class _0246_StrobogrammaticNumber {

    public static void main(String[] args) {
    }


    //11, 101, 181, 619, 16091, 18181, 19861, 61819, 116911, 119611, 160091,
    // 169691, 191161, 196961, 686989, 688889
    public boolean isStrobogrammatic(String num) {
        Set<String> set = new HashSet<>();
        set.add("00");
        set.add("11");
        set.add("88");
        set.add("69");
        set.add("96");

        for (int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            if (!set.contains(num.charAt(left) + "" + num.charAt(right))) {
                return false;
            }
        }
        return true;
    }



}

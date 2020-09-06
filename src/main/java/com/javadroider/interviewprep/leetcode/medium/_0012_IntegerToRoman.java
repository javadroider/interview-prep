package com.javadroider.interviewprep.leetcode.medium;

public class _0012_IntegerToRoman {

    public String intToRoman(int num) {
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ret = "";
        for (int i = 0; i < values.length; i++) {
            while (values[i] <= num) {
                ret = ret + roman[i];
                num = num - values[i];
            }
        }
        return ret;
    }
}

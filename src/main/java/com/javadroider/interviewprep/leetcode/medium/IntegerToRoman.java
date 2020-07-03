package com.javadroider.interviewprep.leetcode.medium;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(2038));
    }

    public static String intToRoman(int num) {
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ret = "";
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                ret = ret + roman[i];
                num = num - values[i];
            }
        }
        return ret;
    }
}

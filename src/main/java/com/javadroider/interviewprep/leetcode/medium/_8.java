package com.javadroider.interviewprep.leetcode.medium;

public class _8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int idx = 0;
        int sign = 1;
        int res = 0;
        //remove white spaces
        while (idx < len && str.charAt(idx) == ' ') {
            idx++;
        }

        //find out sign
        if (idx < len && (str.charAt(idx) == '-' || str.charAt(idx) == '+')) {
            sign = str.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }

        while (idx < len) {
            int digit = str.charAt(idx) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            int temp = Integer.MAX_VALUE / 10;
            int temp1 = Integer.MAX_VALUE % 10;
            boolean flag = res >= temp;
            if (res > temp || res == temp && digit > temp1) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            idx++;
        }

        return res * sign;

    }
}

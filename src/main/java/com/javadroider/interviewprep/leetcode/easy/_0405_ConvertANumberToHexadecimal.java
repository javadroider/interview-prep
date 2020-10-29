package com.javadroider.interviewprep.leetcode.easy;

public class _0405_ConvertANumberToHexadecimal {

    public static void main(String[] args) {
        _0405_ConvertANumberToHexadecimal instance = new _0405_ConvertANumberToHexadecimal();
        int number = 380;
        String hex = instance.toHex(number);
        System.out.println(hex);
        int convertedNumber = instance.toNumber(hex);
        System.out.println(convertedNumber);
        System.out.println(instance.hex_to_decimal(hex));
    }

    //https://leetcode.com/problems/convert-a-number-to-hexadecimal/discuss/89253/Simple-Java-solution-with-comment
    public String toHex(int num) {
        /*
            15 -> 1111
            380 -> 101111100
            1. 1100 & 1111 -> 1100 = c (1100 => 1*2^3 + 1*2^2 + 0*2^1 + 0*2^0) (8 + 4 + 0 + 0)
            2. right shift 101111100 => 10111
            3. 0111 & 1111 -> 0111 = 7
            4. right shift 10111 => 0001
            5. 0001 & 1111 -> 1 = 1
            hexValue = 17c

            1*16^2 + 7*16^1 + 12 * 16^0
            256 + 112 + 12 = 380

         */
        if (num == 0) {
            return "0";
        }
        String hexValue = "";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0) {
            hexValue = hex[num & 15] + hexValue;
            num = num >>> 4;
        }

        return hexValue;
    }

    //https://www.w3resource.com/java-exercises/basic/java-basic-exercise-28.php
    public int hex_to_decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }

    private int toNumber(String hex) {
        int ret = 0;
        int count = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            int num = 0;
            char ch = hex.charAt(i);
            if (ch >= 'a' && ch <= 'f') {
                num = ch - 'a' + 10;
            } else if (ch >= '0' && ch <= '9') {
                num = ch - '0';
            }
            ret += Math.pow(16, count) * num;
            count++;
        }
        return ret;
    }
}

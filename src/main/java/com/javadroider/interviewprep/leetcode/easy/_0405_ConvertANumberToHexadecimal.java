package com.javadroider.interviewprep.leetcode.easy;

public class _0405_ConvertANumberToHexadecimal {

    //https://leetcode.com/problems/convert-a-number-to-hexadecimal/discuss/89253/Simple-Java-solution-with-comment
    public String toHex(int num) {
        /*
            15 -> 1111
            380 -> 101111100
            1. 1100 & 1111 -> 1100 = c
            2. right shift 101111100 => 10111
            3. 0111 & 1111 -> 0111 = 7
            4. right shift 10111 => 0001
            5. 0001 & 1111 -> 1 = 1
            hexValue = 17c
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
}

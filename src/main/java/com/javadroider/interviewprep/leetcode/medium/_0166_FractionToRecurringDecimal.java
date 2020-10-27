package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0166_FractionToRecurringDecimal {

    public static void main(String[] args) {
        System.out.println(new _0166_FractionToRecurringDecimal().fractionToDecimal(2, 3));
    }

    //https://leetcode.com/problems/fraction-to-recurring-decimal/solution/
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }

        long divisor = Math.abs(Long.valueOf(denominator));
        long dividend = Math.abs(Long.valueOf(numerator));
        result.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            Integer remainderIndex = map.get(remainder);
            if (remainderIndex != null) {
                result.insert(remainderIndex, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / divisor);
            remainder %= divisor;
        }

        return result.toString();
    }
}

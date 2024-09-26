package com.javadroider.interviewprep.leetcode.easy;

public class _0067_AddBinary {

    public static void main(String[] args) {
        System.out.println(new _0067_AddBinary().addBinary("11","1"));;
    }

    public String addBinary(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (l1 >= 0 || l2 >= 0) {
            int sum = 0;
            if (l1 >= 0) {
                sum += a.charAt(l1) - '0';
                l1--;
            }
            if (l2 >= 0) {
                sum += b.charAt(l2) - '0';
                l2--;
            }
            sum += carry;
            int digit = sum % 2;
            sb.append(digit);
            carry = sum / 2;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public String addBinary1(String a, String b) {

        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int sum = 0;
            if (l1 >= 0) {
                sum += a.charAt(l1) - '0';
                l1--;
            }
            if (l2 >= 0) {
                sum += b.charAt(l2) - '0';
                l2--;
            }
            sum += carry;
            int digit = sum % 2;
            sb.insert(0, digit);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}

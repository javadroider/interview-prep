package com.javadroider.interviewprep.leetcode.easy;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("Z"));
    }

    public int titleToNumber(String s) {

        int cnt = s.length() - 1;
        int ret = 0;
        for (int i = 0; i <= cnt; i++) {
            ret += Math.pow(26, cnt) * ((int) s.charAt(i) - (int) 'A' + 1);
            cnt--;
        }

        return ret;
    }
}

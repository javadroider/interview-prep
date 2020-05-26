package com.javadroider.interviewprep.leetcode.easy;

public class ExcelSheetColumnTitle {


    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
    }

    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer("");
        while (n > 0) {
            n--;
            char character = (char) ('A' + n % 26);
            sb.append(character);
            n = n / 26;
        }
        return sb.toString();
    }
}

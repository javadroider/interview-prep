package com.javadroider.interviewprep.leetcode.medium;

public class _0043_MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(new _0043_MultiplyStrings().multiply("123", "45"));
    }

    //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    /*

      Start from right to left, perform multiplication on every pair of digits, and add them together.
      Let's draw the process! From the following draft, we can immediately conclude:
     `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`

     */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = pos[p2] + mul;
                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

package com.javadroider.interviewprep.leetcode.medium;

public class _0091_DecodeWays {

    public static void main(String[] args) {
        System.out.println(new _0091_DecodeWays().numDecodings("112"));
        System.out.println(new _0091_DecodeWays().numDecodingsRecursive("112"));

    }

    //https://www.youtube.com/watch?v=aCKyFYF9_Bg  -> Deserve
    public int numDecodingsRecursive(String s) {
        int len = s.length();
        if (len == 1 || len == 0) {
            return 1;
        }
        /*
            numDecodingsRecursive(112) = numDecodingsRecursive(11)'2' + numDecodingsRecursive(1)'12'
            numDecodingsRecursive(11) = numDecodingsRecursive(1)'1' + numDecodingsRecursive("")'11'
            numDecodingsRecursive(1) = numDecodingsRecursive("")'1'
            numDecodingsRecursive("") = 1

         */
        int count = 0;
        int oneDigit = Integer.parseInt(s.substring(len - 1, len));
        if (oneDigit > 0) {
            count += numDecodingsRecursive(s.substring(0, len - 1));
        }

        int twoDigit = Integer.parseInt(s.substring(len - 2, len));
        if (twoDigit > 9 && twoDigit < 27) {
            count += numDecodingsRecursive(s.substring(0, len - 2));
        }

        return count;
    }

    //https://www.youtube.com/watch?v=cQX3yHS0cLo
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        /*
           0 1 2
           1,1,2
           12
           2
           12


        */
        for (int i = 2; i < s.length() + 1; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit > 0) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits < 27) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}

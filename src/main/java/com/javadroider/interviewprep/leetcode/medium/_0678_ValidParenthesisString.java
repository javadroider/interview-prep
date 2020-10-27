package com.javadroider.interviewprep.leetcode.medium;

public class _0678_ValidParenthesisString {

    //https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/Short-Java-O(n)-time-O(1)-space-one-pass
    // For explanation: https://leetcode.com/problems/valid-parenthesis-string/solution/
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                //c is *
                //consider it as )
                if (low > 0) {
                    low--;
                }
                //consider it as (
                high++;
            }
            //cannot have more ) at any point
            if (high < 0) {
                return false;
            }
        }
        //check if ( is balanced
        return low == 0;
    }
}

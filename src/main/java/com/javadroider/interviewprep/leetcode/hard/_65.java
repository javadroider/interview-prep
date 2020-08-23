package com.javadroider.interviewprep.leetcode.hard;

public class _65 {

    /**
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     */
    public static void main(String[] args) {
        String s1 = "1+";
        String s = s1;
        System.out.println(new _65().isNumber(s));
    }

    //https://leetcode.com/problems/valid-number/discuss/23738/Clear-Java-solution-with-ifs
    public boolean isNumber(String s) {

        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numSeen = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '.':
                    if (dotSeen || eSeen) {
                        return false;
                    }
                    dotSeen = true;
                    break;
                case 'e':
                    if (eSeen || !numSeen) {
                        return false;
                    }
                    eSeen = true;
                    //to handle scenario 1e
                    numSeen = false;
                    break;
                case '-':
                case '+':
                    if (i > 0 && s.charAt(i - 1) != 'e') {
                        return false;
                    }
                    break;
                default:
                    if (ch < '0' || ch > '9') {
                        return false;
                    }
                    numSeen = true;
            }
        }

        return numSeen;
    }
}

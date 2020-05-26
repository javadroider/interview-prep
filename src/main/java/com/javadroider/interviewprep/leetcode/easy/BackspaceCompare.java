package com.javadroider.interviewprep.leetcode.easy;

public class BackspaceCompare {

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backspaceCompare("ab##", "c#d#"));
    }

    public boolean backspaceCompareBad(String S, String T) {
        return getTrimmedString(S).equals(getTrimmedString(T));
    }

    private String getTrimmedString(String str) {
        String temp = "";
        int skip = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                temp += c;
            }
        }
        return temp;
    }

    //Input: S = "ab#c", T = "ad#c"
    public boolean backspaceCompare(String S, String T) {
        int sPtr = S.length() - 1;
        int tPtr = T.length() - 1;
        int countS = 0;
        int countT = 0;
        while (sPtr >= 0 || tPtr >= 0) {
            while (sPtr >= 0 && (countS > 0 || S.charAt(sPtr) == '#')) {
                if (S.charAt(sPtr) == '#') countS++;
                else countS--;
                sPtr--;
            }
            char left = sPtr < 0 ? '@' : S.charAt(sPtr);
            while (tPtr >= 0 && (countT > 0 || T.charAt(tPtr) == '#')) {
                if (T.charAt(tPtr) == '#') countT++;
                else countT--;
                tPtr--;
            }
            char right = tPtr < 0 ? '@' : T.charAt(tPtr);
            if (left != right) return false;
            sPtr--;
            tPtr--;
        }
        return true;
    }

}

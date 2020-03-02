package com.javadroider.interviewprep.leetcode.easy;

public class BackspaceCompare {

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backspaceCompare("a#c", "cd"));
    }

    public boolean backspaceCompare(String S, String T) {
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


    public boolean backspaceCompare1(String S, String T) {
        String STyped = buildString(S);
        String TTyped = buildString(T);
        return STyped.equals(TTyped);
    }


    private String buildString(String toBuild) {
        int currentIndex = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < toBuild.length(); i++) {
            if(toBuild.charAt(i) == '#') {
                if(sb.length() >= 1) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(toBuild.charAt(i));
            }
        }
        return sb.toString();
    }
}

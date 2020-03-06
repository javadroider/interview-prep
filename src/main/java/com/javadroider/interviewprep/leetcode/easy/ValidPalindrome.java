package com.javadroider.interviewprep.leetcode.easy;

public class ValidPalindrome {

    public static void main(String[] args) {
        new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {

        if(s==null || s.trim().length() == 0){
            return true;
        }

        String trimmedString = "";
        for(char c:s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)){
                trimmedString += c;
            }
        }
        trimmedString = trimmedString.toLowerCase();
        int low = 0;
        int high = trimmedString.length() - 1;

        while(low < high){
            if(trimmedString.charAt(low)!=trimmedString.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}

package com.javadroider.interviewprep.leetcode.easy;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("XXVIII"));
    }

    private static int romanToInt(String s) {
        int cur=0,sum=0,prev=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I':cur=1;break;
                case 'V':cur=5;break;
                case 'X':cur=10;break;
                case 'L':cur=50;break;
                case 'C':cur=100;break;
                case 'D':cur=500;break;
                case 'M':cur=1000;break;
            }
            if(prev>cur){
                cur=cur*-1;
            }
            prev=cur;
            sum = sum+cur;
        }
        return sum;
    }
}

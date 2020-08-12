package com.javadroider.interviewprep.leetcode.easy;

public class _415 {
    public static void main(String[] args) {
        System.out.println(new _415().addStrings("123","34"));
    }
    public String addStrings(String num1, String num2) {
        if(num1 == null && num2 == null){
            return num1;
        }

        if(num1 == null){
            return num2;
        }

        if(num2 == null){
            return num1;
        }
        int one = num1.length() - 1;
        int two = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(one >= 0 || two >= 0){
            int temp = carry;
            if(one >= 0){
                temp += num1.charAt(one) - '0';
                one--;
            }
            if(two >= 0){
                temp += num2.charAt(two) - '0';
                two--;
            }
            sb.append(temp % 10);
            carry = temp / 10;
        }
        /*
            1 2
            3 4
            ----
            4 6

        */
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

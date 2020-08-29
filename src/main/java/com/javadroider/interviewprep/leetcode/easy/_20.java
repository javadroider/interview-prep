package com.javadroider.interviewprep.leetcode.easy;

import java.util.*;

public class _20 {

    public static void main(String[] args) {
        System.out.println(new _20().isValid("{{("));
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.empty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.empty();
    }

    private boolean isValid(String s) {
        Map<String,String> map1 = new HashMap<>();
        map1.put("(",")");
        map1.put("{","}");
        map1.put("[","]");

        Map<String,String> map2 = new HashMap<>();
        map2.put("}","{");
        map2.put("]","[");
        map2.put(")","(");


        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            if(map1.containsKey(character)){
                stack.push(character);
            }else if(map2.containsKey(character)){
                if(stack.empty()){
                    return false;
                }
                String temp = stack.peek();
                if(!temp.equals(map2.get(character))){
                   return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}

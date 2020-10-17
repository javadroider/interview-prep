package com.javadroider.interviewprep.leetcode.medium;

public class _0921_MinimumAddToMakeParenthesesValid {

    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181132/C++JavaPython-Straight-Forward-One-Pass/403235
    public int minAddToMakeValid(String S) {
        int stackSize = 0;
        int missing = 0;

        for(char ch : S.toCharArray()){
            if(ch == '('){
                stackSize++;
            }else if(ch == ')' && stackSize > 0){
                stackSize--;
            }else{
                missing++;
            }
        }

        return stackSize + missing;
    }
}

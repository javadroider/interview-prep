package com.javadroider.interviewprep.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _0412_FizzBuzz {

    public static void main(String[] args) {
        System.out.println(new _0412_FizzBuzz().fizzBuzz(3));
    }

    //https://leetcode.com/problems/fizz-buzz/solution/
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int num = 1; num <= n; num++) {
            boolean divisibleBy3 = num % 3 == 0;
            boolean divisibleBy5 = num % 5 == 0;

            if (divisibleBy3 && divisibleBy5) {
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                ans.add("Fizz");
            } else if (divisibleBy5) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(num));
            }
        }

        return ans;
    }

}

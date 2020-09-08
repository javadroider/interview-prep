package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", n, 0, 0);
        return res;
    }

    private static void generateParenthesis(List<String> res, String str, int len, int left, int right) {
        if (str.length() == len * 2) {
            res.add(str);
        }

        if (left < len) {
            generateParenthesis(res, str + "(", len, left + 1, right);
        }
        if (right < left) {
            generateParenthesis(res, str + ")", len, left, right + 1);
        }
    }
}

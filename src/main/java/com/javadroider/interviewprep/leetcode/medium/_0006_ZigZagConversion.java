package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _0006_ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(new _0006_ZigZagConversion().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {

        StringBuilder[] sb = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            sb[i] = new StringBuilder();
        }

        boolean goingDownwards = false;
        int index = 0;
        for (char ch : s.toCharArray()) {
            sb[index].append(ch);
            if (index == 0 || index == numRows - 1) {
                goingDownwards = !goingDownwards;
            }
            index += goingDownwards ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder t : sb) {
            res.append(t);
        }

        return res.toString();
    }

    //https://leetcode.com/problems/zigzag-conversion/solution/
    public String convert1(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}

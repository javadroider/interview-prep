package com.javadroider.interviewprep.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class _0824_GoatLatin {

    //https://leetcode.com/problems/goat-latin/solution/
    public String toGoatLatin(String S) {

        StringBuilder res = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String stuff = "";
        for (String str : S.split(" ")) {
            stuff += 'a';
            if (!vowels.contains(str.charAt(0))) {
                str = str.substring(1) + str.charAt(0);
            }
            res.append(str).append("ma").append(stuff).append(" ");
        }

        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }
}

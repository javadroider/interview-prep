package com.javadroider.interviewprep;

import java.util.List;
import java.util.Map;

/*

Input:
This is a simple example to demonstrate the
problem and the expected output. What follows might
not make much sense but, it is all about having some
text to demo input.

keywords:
simple
the
about

Output:

simple, total: 1
line: 1, occurrences: 1

the, total: 2
line: 1, occurrences: 1
line: 2, occurrences: 1

about, total: 1
line: 3, occurrences:1
*/

class Solution {
    public static void main(String[] args) {
        final List<String> lines = List.of(
                "This is a simple example to demonstrate the ",
                "problem and the expected output. What follows might",
                "not make much sense but, it is all about having some",
                "text as demo input."
        );
        /**
        simple, the, total : 2
        line: 1, occurrences: 2

        the , total : 1
        line: 2, occurrences: 3
        **/
        final List<String> keywords = List.of(
                "simple",
                "the",
                "about"
        );
        findOccurrences(lines, keywords);
    }

    static void findOccurrences(List<String> lines, List<String> keywords) {

        int lineCount;
        for(String line : lines){
            String tokens[] = line.split("\\s");
            for(String token: tokens){

            }
        }
    }

    private static class WordVo{
        public int val;
        public Map<String, Integer> map;
    }
}

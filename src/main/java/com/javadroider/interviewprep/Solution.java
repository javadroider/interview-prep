package com.javadroider.interviewprep;

import java.util.*;

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
        int occurrences = 0;
        for (int i = 0; i < lines.size(); i++) {
            String[] tokens = lines.get(i).split("\\s");
            Set<String> keywordsInLine = new HashSet<>();

            for (String token : tokens) {
                if (keywords.contains(token)) {
                    keywordsInLine.add(token);
                    occurrences++;
                }
            }
            System.out.println(keywordsInLine + ", Total: " + keywordsInLine.size());
            System.out.println("Line: " + (i + 1) + ", Occurrences: " + occurrences);
        }

    }

    private static class WordVo {
        public int val;
        public Map<String, Integer> map;
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

/*

An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
     ↓
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
     ↓   ↓    ↓    ↓  ↓
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
     ↓   ↓    ↓
d) l|ocalizatio|n          --> l10n

Additionally for any string s of size less than or equal to 2 their abbreviation is the same string s.

Find whether its abbreviation is unique in the dictionary. A word's abbreviation is called unique if any of the following conditions is met:

    There is no word in dictionary such that their abbreviation is equal to the abbreviation of word.
    Else, for all words in dictionary such that their abbreviation is equal to the abbreviation of word those words are equal to word.

Example 1:
Input
["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique"]
[[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"]]
Output
[null, false, true, false, true]

Explanation
ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
validWordAbbr.isUnique("dear"); // return False
validWordAbbr.isUnique("cart"); // return True
validWordAbbr.isUnique("cane"); // return False
validWordAbbr.isUnique("make"); // return True

Constraints:
    Each word will only consist of lowercase English characters.

 */
public class _0288_UniqueWordAbbreviation {

    public static void main(String[] args) {
        String[] dict = {"deer", "door", "cake", "card"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dict);
        System.out.println(validWordAbbr.isUnique("dear")); // return False
        System.out.println(validWordAbbr.isUnique("cart")); // return True
        System.out.println(validWordAbbr.isUnique("cane")); // return False
        System.out.println(validWordAbbr.isUnique("make")); // return True
    }

    //https://leetcode.com/problems/unique-word-abbreviation/solution/
    static class ValidWordAbbr {

        private Map<String, Set<String>> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String word : dictionary) {
                String abbr = getAbbrWord(word);
                map.putIfAbsent(abbr, new HashSet<>());
                map.get(abbr).add(word);
            }
        }

        private String getAbbrWord(String word) {
            int n = word.length();

            if (n <= 2) {
                return word;
            }

            return word.charAt(0) + String.valueOf(n - 2) + word.charAt(word.length() - 1);
        }

        public boolean isUnique(String word) {
            String abbrWord = getAbbrWord(word);
            Set<String> words = map.get(abbrWord);
            return words == null || words.size() == 1 && words.contains(word);
        }
    }
}

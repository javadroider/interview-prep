package com.javadroider.interviewprep.leetcode.easy;

/*

 Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

 */
public class _0408_ValidWordAbbreviation {

    public static void main(String[] args) {
        System.out.println(new _0408_ValidWordAbbreviation().validWordAbbreviation("internationalization", "i12iz4n"));
    }

    //https://leetcode.com/problems/valid-word-abbreviation/discuss/89523/Short-and-easy-to-understand-Java-Solution/275784
    public boolean validWordAbbreviation(String word, String abbr) {

        int wordIndex = 0;
        int n = 0;
        for (char aChar : abbr.toCharArray()) {
            if (aChar >= '0' && aChar <= '9') {
                n = n * 10 + (aChar - '0');
                if (n == 0) {
                    return false; // word : "a" abbr : "01"
                }
            } else {
                wordIndex += n;
                if (wordIndex >= word.length() || word.charAt(wordIndex) != aChar) {
                    return false;
                }
                n = 0;
                wordIndex++;
            }
        }
        // + n is needed for word: "internationalization" abbr: "i5a11o1" word: "word" abbr:"w3"
        return wordIndex + n == word.length(); //
    }
}

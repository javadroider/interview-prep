package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0211_DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));//false
        System.out.println(wordDictionary.search("bad"));//true
        System.out.println(wordDictionary.search(".ad"));//true
        System.out.println(wordDictionary.search("b.."));//true
    }

    //https://leetcode.com/problems/design-add-and-search-words-data-structure/solution/
    static class WordDictionary {

        private Trie root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Trie runner = root;
            for (Character ch : word.toCharArray()) {
                if (!runner.children.containsKey(ch)) {
                    runner.children.put(ch, new Trie());
                }
                runner = runner.children.get(ch);
            }
            runner.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return find(word, root);
        }

        private boolean find(String word, Trie node) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    if (ch == '.') {
                        for (Character ch1 : node.children.keySet()) {
                            if (find(word.substring(i + 1), node.children.get(ch1))) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    node = node.children.get(ch);
                }
            }
            return node.isWord;
        }
    }

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        boolean isWord;
    }

    //https://leetcode.com/problems/design-add-and-search-words-data-structure/discuss/59669/Java-Solution-easy-understand
    static class WordDictionary1 {

        private Map<Integer, List<String>> map = new HashMap<>();

        //O(M), O(M)
        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            int length = word.length();
            map.putIfAbsent(length, new ArrayList<String>());
            map.get(length).add(word);
        }

        //O(M * N), O(M)
        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            int length = word.length();
            if (!map.containsKey(length)) {
                return false;
            }

            List<String> words = map.get(length);
            for (String listWord : words) {
                if (matches(listWord, word)) {
                    return true;
                }
            }

            return false;

        }

        private boolean matches(String listWord, String word) {

            if (listWord.length() != word.length()) {
                return false;
            }

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != '.' && word.charAt(i) != listWord.charAt(i)) {
                    return false;
                }
            }

            return true;
        }
    }
}

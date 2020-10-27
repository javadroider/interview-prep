package com.javadroider.interviewprep.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*

Implement the StreamChecker class as follows:
    StreamChecker(words): Constructor, init the data structure with the given words.
    query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

Note:
    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.

 */
public class _1032_StreamOfCharacters {

    //https://leetcode.com/problems/stream-of-characters/solution/
    class StreamChecker {

        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isWord = false;
        }

        private TrieNode root = new TrieNode();
        private Deque<Character> stream = new ArrayDeque<>();

        public StreamChecker(String[] words) {
            TrieNode runner = root;
            for (String word : words) {
                runner = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char ch = word.charAt(i);
                    if (!runner.children.containsKey(ch)) {
                        runner.children.put(ch, new TrieNode());
                    }
                    runner = runner.children.get(ch);
                }
                runner.isWord = true;
            }
        }

        public boolean query(char letter) {
            stream.addFirst(letter);

            TrieNode runner = root;

            for (char ch : stream) {
                if (runner.isWord) {
                    return true;
                }

                if (!runner.children.containsKey(ch)) {
                    return false;
                }
                runner = runner.children.get(ch);
            }

            return runner.isWord;
        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
}

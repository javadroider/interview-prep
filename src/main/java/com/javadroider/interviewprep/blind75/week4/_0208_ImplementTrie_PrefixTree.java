package com.javadroider.interviewprep.blind75.week4;

public class _0208_ImplementTrie_PrefixTree {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("bat");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("dat"));
    }


    private static class Trie {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode runner = root;
            for (char ch : word.toCharArray()) {
                int charIndex = ch - 'a';
                if (runner.children[charIndex] == null) {
                    runner.children[charIndex] = new TrieNode();
                }
                runner = runner.children[charIndex];
            }

            runner.isWord = true;
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            TrieNode runner = root;
            for (char ch : word.toCharArray()) {
                int charIndex = ch - 'a';
                if (runner.children[charIndex] == null) {
                    return false;
                }
                runner = runner.children[charIndex];
            }
            return runner.isWord;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return false;
            }

            TrieNode runner = root;
            for (char ch : prefix.toCharArray()) {
                int charIndex = ch - 'a';
                if (runner.children[charIndex] == null) {
                    return false;
                }
                runner = runner.children[charIndex];
            }
            return true;
        }
    }
}

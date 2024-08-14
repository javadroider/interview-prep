package com.javadroider.interviewprep.blind75.week4;

public class _0211_DesignAddAndSearchWordsDataStructure {


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }

    public static class WordDictionary {
        class TrieNode {
            TrieNode[] children;
            boolean isEnd;

            TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        // Method to add a word to the trie
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true; // Marking the end of the word
        }

        // Method to search for a word in the trie
        public boolean search(String word) {
            return searchHelper(word, 0, root);
        }

        // Recursive helper method for searching a word
        private boolean searchHelper(String word, int index, TrieNode node) {
            // If reached the end of the word, check if the current node marks the end of a word
            if (index == word.length()) {
                return node.isEnd;
            }

            char c = word.charAt(index);
            // If the character is '.', recursively search through all child nodes
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchHelper(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else { // If the character is a specific letter, move to the corresponding child node
                if (node.children[c - 'a'] == null) {
                    return false; // If the child node doesn't exist, the word doesn't exist in the trie
                }
                return searchHelper(word, index + 1, node.children[c - 'a']);
            }
        }
    }


}

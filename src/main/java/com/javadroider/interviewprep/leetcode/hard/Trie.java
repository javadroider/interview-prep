package com.javadroider.interviewprep.leetcode.hard;

class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("can");
        System.out.println(trie.startsWith("ca"));
        System.out.println(trie.startsWith("ta"));
        System.out.println(trie.search("ca"));
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("can"));
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        
        TrieNode(){
            
        }
    }
    
    private TrieNode root = null;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode runner = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(runner.children[i] == null){
                runner.children[i] = new TrieNode();
            }
            runner = runner.children[i];
        }
        runner.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        TrieNode runner = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(runner.children[i] == null){
                return false;
            }
            runner = runner.children[i];
        }
        return runner.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return false;
        }
        
        TrieNode runner = root;
        for(char c : prefix.toCharArray()){
            int i = c - 'a';
            if(runner.children[i] == null){
                return false;
            }
            runner = runner.children[i];
        }
        
        return true;
    }
}

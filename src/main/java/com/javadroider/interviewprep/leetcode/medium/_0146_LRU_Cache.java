package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _0146_LRU_Cache {

    //https://leetcode.com/problems/lru-cache/solution/
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // evicts key 2
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // evicts key 1
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

    static class LRUCache {

        private DLNode HEAD = null;
        private DLNode REAR = null;
        private Map<Integer, DLNode> map = null;
        private int capacity = 0;
        private int size = 0;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            HEAD = new DLNode(-1, -1);
            REAR = new DLNode(-1, -1);
            HEAD.right = REAR;
            REAR.left = HEAD;
            this.capacity = capacity;
        }

        public int get(int key) {
            DLNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        private void moveToHead(DLNode node) {
            remove(node);
            add(node);
        }

        private void add(DLNode node) {
            //H <-> 1 <-> R   = 2
            DLNode next = HEAD.right;

            HEAD.right = node;
            node.left = HEAD;

            node.right = next;
            next.left = node;
        }

        private void remove(DLNode node) {
            //H <-> 1 <-> 2 <-> R
            DLNode prev = node.left;
            DLNode next = node.right;

            prev.right = next;
            next.left = prev;

        }

        public void put(int key, int value) {
            DLNode node = map.get(key);
            if (node == null) {
                DLNode newNode = new DLNode(key, value);
                map.put(key, newNode);
                add(newNode);
                size++;
                if (size > capacity) {
                    removeOld();
                    size--;
                }
            } else {
                node.val = value;
                moveToHead(node);
            }
        }

        private void removeOld() {
            //H <-> 1 <-> 2 <-> R
            DLNode prev = REAR.left;
            remove(prev);
            map.remove(prev.key);
        }
    }

    private static class DLNode {
        DLNode left;
        DLNode right;
        int key;
        int val;

        DLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

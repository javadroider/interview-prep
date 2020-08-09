package com.javadroider.interviewprep.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int size;
    private Node HEAD;
    private Node REAR;
    private Map<Integer, Node> map = new HashMap<>();

    LRUCache(int size) {
        this.size = size;
        this.HEAD = new Node();
        this.REAR = new Node();
        this.HEAD.right = this.REAR;
        this.REAR.left = this.HEAD;
    }

    void refer(int val) {
        if (map.containsKey(val)) {
            Node node = map.get(val);
            //H<->1<->2<->3<->R
            //H<->2<->1<->3<->R
            // H<->2<->3
            //H<->
            Node leftNode = node.left;//1
            Node rightNode = node.right;//3
            leftNode.right = rightNode;
            rightNode.left = leftNode;
            Node temp = this.HEAD.right;
            node.left = this.HEAD;
            this.HEAD.right = node;
            node.right = temp;
        } else {
            //H > 1 > R
            Node node = new Node();
            node.val = val;
            Node temp = this.HEAD.right;
            node.left = this.HEAD;
            this.HEAD.right = node;
            node.right = temp;
            map.put(val, node);
        }
    }

    void display() {
        Node temp = this.HEAD;
        temp = temp.right;
        while (temp != null && temp != this.REAR) {
            System.out.print(temp.val + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.refer(3);
        lruCache.refer(2);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.display();

    }

    private class Node {
        Node left;
        Node right;
        int val;
    }
}

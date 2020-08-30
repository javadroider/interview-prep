package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _133 {

    //https://leetcode.com/problems/clone-graph/discuss/250216/BFS-and-DFS-simple-Java
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

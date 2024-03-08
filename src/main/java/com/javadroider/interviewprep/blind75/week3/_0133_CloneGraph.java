package com.javadroider.interviewprep.blind75.week3;


import java.util.*;

public class _0133_CloneGraph {
    public Node cloneGraph(Node node) {

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        Node clonedNode = new Node(node.val, new ArrayList<>());
        map.put(node, clonedNode);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbour : temp.neighbors) {
                Node t = map.get(neighbour);
                if (t == null) {
                    t = new Node(neighbour.val, new ArrayList<>());
                    queue.offer(neighbour);
                }
                map.get(temp).neighbors.add(t);
            }
        }

        return clonedNode;
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

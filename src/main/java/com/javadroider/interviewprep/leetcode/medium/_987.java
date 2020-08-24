package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.*;

public class _987 {


    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(9);
        set.add(7);
        System.out.println(set);
        System.out.println(new _987().verticalTraversal(TreeNode.sample4()));
        System.out.println(new _987().verticalTraversalNotWorking(TreeNode.sample4()));
    }

    //[0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]
    //output: [[7,9],[5,6],[0,2,4],[1,3],[8]]
    //expected: [[9,7],[5,6],[0,2,4],[1,3],[8]]
    public List<List<Integer>> verticalTraversalNotWorking(TreeNode root) {
        Map<Integer, TreeSet<Integer>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        verticalTraversal(root, map, 0);
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>(entry.getValue());
            res.add(list);
        }
        return res;
    }

    private void verticalTraversal(TreeNode root, Map<Integer, TreeSet<Integer>> map, int column) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(column)) {
            map.put(column, new TreeSet<>());
        }
        map.get(column).add(root.val);
        verticalTraversal(root.left, map, column - 1);
        verticalTraversal(root.right, map, column + 1);
    }

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231148/Java-TreeMap-Solution
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, TreeSet<Node>> map = new TreeMap<>();
        populate(root, map, 0, 0);
        for (Map.Entry<Integer, TreeSet<Node>> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            for (Node node : entry.getValue()) {
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }

    private void populate(TreeNode root, Map<Integer, TreeSet<Node>> map, int order, int level) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(order)) {
            map.put(order, new TreeSet<>((a, b) -> (a.level == b.level) ? Integer.compare(a.val, b.val) :
                    Integer.compare(a.level, b.level)));
        }
        map.get(order).add(new Node(root.val, level));
        populate(root.left, map, order - 1, level + 1);
        populate(root.right, map, order + 1, level + 1);
    }

    private class Node {
        int val;
        int level;

        Node(int val, int order) {
            this.val = val;
            this.level = order;
        }
    }
}

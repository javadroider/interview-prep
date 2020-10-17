package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class _0863_AllNodesDistanceKInBinaryTree {


    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/438039
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        dfs(parentMap, root, root);


        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int dist = 0;

        queue.offer(target);
        seen.add(target);

        while (!queue.isEmpty() && dist < K) {
            int size = queue.size();
            dist++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }

                if (node.right != null && !seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }

                TreeNode parent = parentMap.get(node);

                if (!seen.contains(parent)) {
                    seen.add(parent);
                    queue.offer(parent);
                }
            }
        }

        return queue.stream().map(n -> n.val).collect(Collectors.toList());
    }

    private void dfs(Map<TreeNode, TreeNode> parentMap, TreeNode root, TreeNode parent) {
        if (root != null) {
            parentMap.put(root, parent);
            dfs(parentMap, root.left, root);
            dfs(parentMap, root.right, root);
        }
    }
}

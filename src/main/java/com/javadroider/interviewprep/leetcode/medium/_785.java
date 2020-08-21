package com.javadroider.interviewprep.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _785 {

    public static void main(String[] args) {
        //int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(new _785().isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        // If this node hasn't been colored
                        colors[next] = -colors[cur];
                        // Color it with a different color
                        queue.offer(next);
                    } else if (colors[next] == colors[cur]) {
                        // If it is colored and its color is different, return false
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

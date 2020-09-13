package com.javadroider.interviewprep.leetcode.medium;

import java.util.PriorityQueue;

public class _0973_KClosestPointsToOrigin {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/k-closest-points-to-origin/discuss/218888/Java-Priority-Queue-Easy-to-Understand
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare((p1[0] * p1[0]) + (p1[1] * p1[1]), (p2[0] * p2[0]) + (p2[1] * p2[1])));

        int[][] res = new int[K][2];

        for (int[] point : points) {
            pq.offer(point);
        }
        int index = 0;
        while (index < K) {
            res[index] = pq.poll();
            index++;
        }

        return res;
    }

    //https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare((p2[0] * p2[0]) + (p2[1] * p2[1]), (p1[0] * p1[0]) + (p1[1] * p1[1])));

        int[][] res = new int[K][2];

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        while (K > 0) {
            res[--K] = pq.poll();
        }

        return res;
    }
}

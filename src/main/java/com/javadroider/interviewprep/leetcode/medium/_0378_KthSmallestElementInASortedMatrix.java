package com.javadroider.interviewprep.leetcode.medium;

import java.util.PriorityQueue;

public class _0378_KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/578461
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                pq.offer(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}

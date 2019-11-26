package com.javadroider.interviewprep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSum {

    /*
        d = diagonal distance
        1. For root
            d=0
        2. For left child
            d = d + 1
        3. For right child
            d = d ( remains same)
            
        https://www.youtube.com/watch?v=I3BC8nEKYm8
    */
    static void diagonalSum(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        int sum = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null) {
                System.out.println("Sum " + sum);
                queue.add(null);
                temp = queue.remove();
                if (temp == null) {
                    break;
                }
                sum = 0;
            }
            while (temp != null) {
                sum += temp.data;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                temp = temp.right;
            }
        }
    }

    public static void main(String[] args) {
        diagonalSum(BinaryTree.sample());
    }
}



package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0406_QueueReconstructionByHeight {

    /*

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

    Sort by height descending, number of people ascending
    [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]

    [7,0]
    [7,0], [7,1]
    [7,0], [6,1], [7,1]
    [5,0], [7,0], [6,1], [7,1]
    [5,0], [7,0], [5,2], [6,1], [7,1]
    [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]

     */
    //https://leetcode.com/problems/queue-reconstruction-by-height/solution/
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[res.size()][2]);
    }
}

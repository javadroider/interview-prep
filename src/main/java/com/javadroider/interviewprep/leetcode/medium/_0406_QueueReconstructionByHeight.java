package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0406_QueueReconstructionByHeight {

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

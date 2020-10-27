package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.leetcode.easy._0339_NestedListWeightSum;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0364_NestedListWeightSumII {

    //https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83655/JAVA-AC-BFS-solution/659736
    public int depthSumInverse(List<_0339_NestedListWeightSum.NestedInteger> nestedList) {
        int result = 0;
        int runningSum = 0;
        Queue<_0339_NestedListWeightSum.NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();        // These are all the nodes in the current level.
            while (size > 0) {
                _0339_NestedListWeightSum.NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger()) {
                    runningSum += nestedInteger.getInteger();
                } else {
                    queue.addAll(nestedInteger.getList());
                }
                size--;
            }
            result += runningSum;   // Add integers in current level to the result and again all integers from all previous levels.
        }
        return result;
    }
}

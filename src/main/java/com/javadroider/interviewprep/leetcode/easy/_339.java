package com.javadroider.interviewprep.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _339 {

    //https://leetcode.com/problems/nested-list-weight-sum/discuss/79933/Java-Solution%3A-similar-to-tree-level-order-traversal
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int counter = 0;
            while (counter < size) {
                NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger()) {
                    sum += (nestedInteger.getInteger() * level);
                } else {
                    queue.addAll(nestedInteger.getList());
                }
                counter--;
            }
            level++;
        }
        return sum;
    }

    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        //public NestedInteger();

        // Constructor initializes a single integer.
        //public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}

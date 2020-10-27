package com.javadroider.interviewprep.leetcode.easy;

import java.util.*;

public class _0339_NestedListWeightSum {

    public static void main(String[] args) {

        List<NestedInteger> nestedList = new ArrayList<>();

        //[1,[4,[6]]]
        NestedInteger ni1 = new NestedIntegerImpl(1);
        NestedInteger ni4 = new NestedIntegerImpl(4);
        NestedInteger ni6 = new NestedIntegerImpl(6);
        nestedList.add(ni1);
        NestedInteger g1 = new NestedIntegerImpl();
        g1.add(ni4);
        NestedInteger g2 = new NestedIntegerImpl();
        g2.add(ni6);
        g1.add(g2);
        nestedList.add(g1);

        //[[1,1],2,[1,1]]
//        NestedInteger ni11 = new NestedIntegerImpl(1);
//        NestedInteger ni12 = new NestedIntegerImpl(1);
//        NestedInteger ni1g = new NestedIntegerImpl();
//        ni1g.add(ni11);
//        ni1g.add(ni12);
//
//        NestedInteger ni2 = new NestedIntegerImpl(2);
//
//        NestedInteger ni13 = new NestedIntegerImpl(1);
//        NestedInteger ni14 = new NestedIntegerImpl(1);
//        NestedInteger ni2g = new NestedIntegerImpl();
//        ni2g.add(ni13);
//        ni2g.add(ni14);
//
//        nestedList.add(ni1g);
//        nestedList.add(ni2);
//        nestedList.add(ni2g);

        System.out.println(new _0339_NestedListWeightSum().depthSum(nestedList));
        System.out.println(new _0339_NestedListWeightSum().depthSumInverse(nestedList));
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int result = 0;
        int runningSum = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();        // These are all the nodes in the current level.
            while (size > 0) {
                NestedInteger nestedInteger = queue.poll();
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
            while (size > 0) {
                NestedInteger nestedInteger = queue.poll();
                if (nestedInteger.isInteger()) {
                    sum += (nestedInteger.getInteger() * level);
                } else {
                    queue.addAll(nestedInteger.getList());
                }
                size--;
            }
            level++;
        }
        return sum;
    }

    //https://leetcode.com/problems/nested-list-weight-sum/solution/
    public int depthSum1(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }

    public static class NestedIntegerImpl implements NestedInteger {

        private Integer num;

        private List<NestedInteger> nestedIntegerList;

        public NestedIntegerImpl() {
        }

        public NestedIntegerImpl(int value) {
            num = value;
        }

        @Override
        public boolean isInteger() {
            return nestedIntegerList == null;
        }

        @Override
        public Integer getInteger() {
            return num;
        }

        @Override
        public void setInteger(int value) {
            this.num = value;
        }

        @Override
        public void add(NestedInteger ni) {
            if (nestedIntegerList == null) {
                nestedIntegerList = new ArrayList<>();
            }
            nestedIntegerList.add(ni);
        }

        @Override
        public List<NestedInteger> getList() {
            return nestedIntegerList;
        }
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

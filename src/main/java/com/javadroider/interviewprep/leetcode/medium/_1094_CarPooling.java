package com.javadroider.interviewprep.leetcode.medium;

import java.util.TreeMap;

public class _1094_CarPooling {

    //https://leetcode.com/problems/car-pooling/solution/
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            int startPassenger = map.getOrDefault(trip[1], 0) + trip[0];
            map.put(trip[1], startPassenger);

            int endPassenger = map.getOrDefault(trip[2], 0) - trip[0];
            map.put(trip[2], endPassenger);
        }

        int currentCapacity = 0;
        for (int p : map.values()) {
            currentCapacity += p;
            if (currentCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}

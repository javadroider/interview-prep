package com.javadroider.interviewprep.leetcode.medium;

public class _0134_GasStation {

    //https://leetcode.com/problems/gas-station/solution/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int currTank = 0;
        int startingStation = 0;
        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            // If one couldn't get here,
            if (currTank < 0) {
                // Pick up the next station as the starting one.
                startingStation = i + 1;
                // Start with an empty tank.
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }
}

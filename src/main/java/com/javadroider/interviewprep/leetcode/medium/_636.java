package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _636 {

    public static void main(String[] args) {
        String[] logs = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        System.out.println(Arrays.toString(new _636().exclusiveTime(2, Arrays.asList(logs))));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] tokens = log.split(":");
            int id = Integer.parseInt(tokens[0]);
            String action = tokens[1];
            int timeStamp = Integer.parseInt(tokens[2]);
            if ("start".equals(action)) {
                if (!stack.empty()) {
                    res[stack.peek()] += timeStamp - prev;
                }
                stack.push(id);
                prev = timeStamp;
            } else {
                res[stack.pop()] += timeStamp - prev + 1;
                prev = timeStamp + 1;
            }
        }

        return res;
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0621_TaskScheduler {

    public static void main(String[] args) {
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new _0621_TaskScheduler().leastInterval(tasks1, 0));
    }

   //https://leetcode.com/problems/task-scheduler/discuss/104501/Java-PriorityQueue-solution-Similar-problem-Rearrange-string-K-distance-apart
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return -1;
        //build map to sum the amount of each task
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // build queue, sort from descending
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        queue.addAll(map.entrySet());


        int cnt = 0;
        // when queue is not empty, there are remaining tasks
        while (!queue.isEmpty()) {
            // for each interval
            int interval = n + 1;
            // list used to update queue
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            // fill the intervals with the next high freq task
            while (interval > 0 && !queue.isEmpty()) {
                Map.Entry<Character, Integer> entry = queue.poll();
                entry.setValue(entry.getValue() - 1);
                list.add(entry);
                // interval shrinks
                interval--;
                // one slot is taken
                cnt++;
            }

            // update the value in the map
            for (Map.Entry<Character, Integer> entry : list) {
                // when there is left task
                if (entry.getValue() > 0)
                    queue.offer(entry);
            }
            // job done
            if (queue.isEmpty())
                break;
            // if interval is > 0, then the machine can only be idle
            cnt += interval;
        }

        return cnt;
    }
}

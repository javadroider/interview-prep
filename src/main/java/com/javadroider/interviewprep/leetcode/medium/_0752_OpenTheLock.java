package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0752_OpenTheLock {

    public static void main(String[] args) {
        System.out.println(new _0752_OpenTheLock().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    //https://www.youtube.com/watch?v=IHT8Sx0832k
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        seen.add("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String current = queue.poll();
                if (deadSet.contains(current)) {
                    size--;
                    continue;
                }
                if (target.equals(current)) {
                    return level;
                }
                for (int i = 0; i < 4; i++) {
                    char currentChar = current.charAt(i);
                    String s1 = current.substring(0, i) + (currentChar == '9' ? 0 : currentChar - '0' + 1) + current.substring(i + 1);
                    String s2 = current.substring(0, i) + (currentChar == '0' ? 9 : currentChar - '0' - 1) + current.substring(i + 1);
                    if (!deadSet.contains(s1) && !seen.contains(s1)) {
                        queue.offer(s1);
                        seen.add(s1);
                    }

                    if (!deadSet.contains(s2) && !seen.contains(s2)) {
                        queue.offer(s2);
                        seen.add(s2);
                    }
                }
                size--;
            }
            level++;
        }

        return -1;

    }
}

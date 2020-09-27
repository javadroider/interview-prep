package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0767_ReorganizeString {

    public static void main(String[] args) {
        System.out.println(new _0767_ReorganizeString().reorganizeString("aab"));
    }

    //https://leetcode.com/problems/reorganize-string/solution/
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        int n = S.length();
        for (Character ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<MultiChar> pq = new PriorityQueue<>((mc1, mc2) -> mc1.count == mc2.count ? Integer.compare(mc1.letter, mc2.letter) : Integer.compare(mc2.count, mc1.count));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new MultiChar(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            sb.append(mc1.letter);
            sb.append(mc2.letter);

            if (mc1.count > 1) {
                mc1.count--;
                pq.offer(mc1);
            }

            if (mc2.count > 1) {
                mc2.count--;
                pq.offer(mc2);
            }
        }

        if (pq.size() > 0) {
            sb.append(pq.poll().letter);
        }

        return sb.toString();
    }

    public class MultiChar {
        int count;
        char letter;

        MultiChar(char l, int c) {
            this.count = c;
            this.letter = l;
        }
    }

}

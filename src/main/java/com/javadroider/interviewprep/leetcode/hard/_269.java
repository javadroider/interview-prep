package com.javadroider.interviewprep.leetcode.hard;

import java.util.*;

public class _269 {

    public static void main(String[] args) {
        String[] words = {"za", "zb", "ca", "cb"};
        //System.out.println(new _269().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(new _269().alienOrder1(words));
    }

    //https://leetcode.com/problems/alien-dictionary/discuss/70119/Java-AC-solution-using-BFS
    public String alienOrder1(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String result = "";
        if (words == null || words.length == 0) return result;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            // ["wrtkj","wrt"]
            if (cur.length() > next.length() && cur.startsWith(next)) {
                return "";
            }
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.remove();
            result += c;
            if (map.containsKey(c)) {
                for (char neighbour : map.get(c)) {
                    degree.put(neighbour, degree.get(neighbour) - 1);
                    if (degree.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result;
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                graph.put(ch, new HashSet<>());
            }
        }

        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);
        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.keySet().size() ? order : "";
    }

    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

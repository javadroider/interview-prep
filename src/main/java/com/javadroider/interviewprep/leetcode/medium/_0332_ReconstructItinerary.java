package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0332_ReconstructItinerary {

    public static void main(String[] args) {
        //[JFK, ATL, JFK, SFO, ATL, SFO]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
        //tickets.add(Arrays.asList());
        System.out.println(new _0332_ReconstructItinerary().findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> flightMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            flightMap.putIfAbsent(origin, new LinkedList<>());
            flightMap.get(origin).add(dest);
        }
        flightMap.forEach((key, value) -> Collections.sort(value));
        LinkedList<String> res = new LinkedList<>();
        explore(flightMap, res, "JFK");
        return res;
    }

    private void explore(Map<String, LinkedList<String>> flightMap, LinkedList<String> result, String source) {
        if (flightMap.containsKey(source)) {
            LinkedList<String> destList = flightMap.get(source);
            while (!destList.isEmpty()) {
                String dest = destList.pollFirst();
                explore(flightMap, result, dest);
            }
        }
        result.addFirst(source);
    }


}

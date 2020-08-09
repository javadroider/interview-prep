package com.javadroider.interviewprep.companies.dh;

import java.util.*;

public class FishProblem {

    public static void main(String[] args) {



    }

    private static int solution(String S){
        Map<Character, List<Character>> fishMap = new HashMap<>();
        fishMap.put('B', Arrays.asList(new Character[]{'A'}));
        fishMap.put('C', Arrays.asList(new Character[]{'A', 'B'}));
        fishMap.put('D', Arrays.asList(new Character[]{'B', 'C'}));

        Stack<Character> liveFishes = new Stack<>();
        liveFishes.push(S.charAt(S.length() - 1));
        for (int i = S.length() - 2; i >= 0; i--) {
            Character ch = S.charAt(i);
            Character popch = liveFishes.pop();
            Character liveFish = canEat(fishMap, popch, ch);
            if (null != liveFish) {
                if (!liveFishes.isEmpty()) {
                    eatFurther(liveFish, liveFishes, fishMap);
                }
                liveFishes.push(liveFish);
            } else {
                liveFishes.push(popch);
                liveFishes.push(ch);
            }
        }
        return liveFishes.size();
    }

    private static void eatFurther(Character liveFish, Stack<Character> liveFishes, Map<Character, List<Character>> fishMap) {
        boolean repeat = false;
        do {
            repeat = false;
            Character ch = liveFishes.peek();
            if (fishMap.containsKey(ch)) {
                List<Character> eatingFishes = fishMap.get(ch);
                if (eatingFishes.contains(liveFish)) {
                    liveFishes.pop();
                    repeat = true;
                }
            }

        } while (repeat && !liveFishes.isEmpty());
    }

    private static Character canEat(Map<Character, List<Character>> fishMap, Character f1, Character f2) {
        if (f1.compareTo(f2) == 0) {
            return null;
        } else if (fishMap.containsKey(f1)) {
            List<Character> eatingFishes = fishMap.get(f1);
            if (eatingFishes.contains(f2)) {
                return f2;
            }
        } else if (fishMap.containsKey(f2)) {
            List<Character> eatingFishes = fishMap.get(f2);
            if (eatingFishes.contains(f1)) {
                return f1;
            }
        }
        return null;
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class _528 {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(3, 3);
        map.put(5, 5);
        //System.out.println(map.ceilingKey(3));
        //System.out.println(map.higherKey(3));
        for (int i = 0; i < 10; i++) {
            System.out.print(new Random().nextInt(6 + 1)  +" ");
        }
    }


    //https://leetcode.com/problems/random-pick-with-weight/discuss/154024/JAVA-8-lines-TreeMap
    class Solution {

        int[] arr;
        int max = 0;
        Random random = new Random();
        private TreeMap<Integer, Integer> map = new TreeMap<>();

        public Solution(int[] w) {
            for (int i = 0; i < w.length; i++) {
                max += w[i];
                map.put(max, i);
                //[1,2,3] -> 1:0, 3:1, 6:2
            }
        }

        public int pickIndex() {
            int key = map.higherKey(random.nextInt(max));
            return map.get(key);
        }

    }

}

package com.javadroider.interviewprep.blind75.week1;

import java.util.HashMap;
import java.util.Map;

public class _0217_ContainsDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                return true;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return false;

    }

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                return true;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return false;
    }

}

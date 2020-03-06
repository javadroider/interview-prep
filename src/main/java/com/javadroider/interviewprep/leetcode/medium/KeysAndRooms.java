package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms instance = new KeysAndRooms();
        System.out.println(instance.canVisitAllRooms(instance.getRooms()));

    }

    private List<List<Integer>> getRooms1(){
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        List<Integer> two = new ArrayList<>();
        two.add(2);
        List<Integer> three = new ArrayList<>();
        three.add(3);
        List<Integer> four = new ArrayList<>();
        rooms.add(one);
        rooms.add(two);
        rooms.add(three);
        rooms.add(four);
        return rooms;
    }

    private List<List<Integer>> getRooms(){
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(3);
        List<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(0);
        two.add(1);
        List<Integer> three = new ArrayList<>();
        three.add(2);
        List<Integer> four = new ArrayList<>();
        four.add(0);
        rooms.add(one);
        rooms.add(two);
        rooms.add(three);
        rooms.add(four);
        return rooms;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        visited[0] = true;
        while (!stack.empty()) {
            int index = stack.pop();
            List<Integer> keys = rooms.get(index);
            for (int key : keys) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }

        return true;

    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] arr2 = {0,1,2,2};
        int[] arr3 = {1,2,3,2,2};
        int[] arr4 = {1,2,1};
        int[] arr5 = {1,0,1,4,1,4,1,2,3};
        System.out.println(new FruitIntoBaskets().totalFruit(arr1));
        System.out.println(new FruitIntoBaskets().mySolution(arr1));

        System.out.println(new FruitIntoBaskets().totalFruit(arr2));
        System.out.println(new FruitIntoBaskets().mySolution(arr2));

        System.out.println(new FruitIntoBaskets().totalFruit(arr3));
        System.out.println(new FruitIntoBaskets().mySolution(arr3));

        System.out.println(new FruitIntoBaskets().totalFruit(arr4));
        System.out.println(new FruitIntoBaskets().mySolution(arr4));

        System.out.println(new FruitIntoBaskets().totalFruit(arr5));
        System.out.println(new FruitIntoBaskets().mySolution(arr5));

    }


    public int mySolution(int[] trees) {
        int max = 0;
        int lastFruit = -1, secondLastFruit = -1;
        Map<Integer, Integer> basket = new HashMap<>(2);
        //1,0,1,4,1,4,1,2,3
        for (int fruit : trees) {
            if (lastFruit == -1) {
                basket.put(fruit, 1);
                lastFruit = fruit;
                continue;
            }
            if (secondLastFruit == -1 && lastFruit != fruit) {
                basket.put(fruit, 1);
                secondLastFruit = lastFruit;
                lastFruit = fruit;
                continue;
            }
            if (basket.containsKey(fruit)) {
                basket.put(fruit, basket.get(fruit) + 1);
                max = Math.max(max, basket.getOrDefault(lastFruit, 0) + basket.getOrDefault(secondLastFruit, 0));
            } else {
                //System.out.println(basket);
                //max = Math.max(max, basket.getOrDefault(lastFruit, 0) + basket.getOrDefault(secondLastFruit, 0));
                max = Math.max(max, basket.get(lastFruit) + basket.get(secondLastFruit));
                basket.remove(secondLastFruit);
                secondLastFruit = lastFruit;
                lastFruit = fruit;
                basket.put(fruit, 1);
            }
        }
        return max;
    }

    public int totalFruit(int[] tree) {
        int res = 0, currentMax = 0, lastFruitCount = 0, secondLastFruit = 0, lastFruit = 0;
        for (int fruit : tree) {
            if (fruit == secondLastFruit || fruit == lastFruit) {
                currentMax = currentMax + 1;
            } else {
                currentMax = lastFruitCount + 1;
            }
            if (fruit == lastFruit) {
                lastFruitCount = lastFruitCount + 1;
            } else {
                lastFruitCount = 1;
            }
            if (lastFruit != fruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            res = Math.max(res, currentMax);
        }
        return res;
    }
}

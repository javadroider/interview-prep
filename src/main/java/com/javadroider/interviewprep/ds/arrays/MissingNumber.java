package com.javadroider.interviewprep.ds.arrays;

import java.io.*;
import java.util.*;

class MissingNumber {

    //https://www.youtube.com/watch?v=Dq0jQX3YNKg
    // Find the missing number in a range
    static int missingNum1(int arr[], int n) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(Integer.valueOf(i));
        }
        int minvalue = Collections.min(list);
        // here we xor of all the number
        int xornum = 0;
        for (int i = 0; i < n; i++) {
            xornum ^= (minvalue) ^ arr[i];
            minvalue++;
        }
        // xor last number
        return xornum ^ minvalue;
    }

    public static int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    static int missingNum2(int array[], int n) {
        int x = array[0];
        int y = 1;
        for (int i = 1; i < n; i++) {
            x = x ^ array[i];
        }

        for (int i = 2; i <= n + 1; i++) {
            y = y ^ i;
        }
        //System.out.println(x);
        //System.out.println(y);
        return x ^ y;
    }

    static int missingNum3(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }

    public static void main(String[] args) {
        //int arr[] = {13, 12, 11, 15};
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int n = arr.length;
        //System.out.println(missingNum1(arr, n));
        System.out.println(missingNumber(arr));
        //System.out.println(missingNum3(arr, n));

    }
}
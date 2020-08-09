package com.javadroider.interviewprep.companies.dh;

public class IncreasingNumbers {

    public static void main(String[] args) {
        //int[]a = {1,2,3,10,11,15} ;
        //int[]a = {3,5,7,10,15} ;
        int[]a = {5,4,2,1} ;
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        int size = 1, maxSize = 1;

        for (int i = 0; i < A.length - 1; i++) {
            if (Math.abs(A[i] - A[i + 1]) == 1) {
                size++;
            } else if (maxSize < size) {
                maxSize = size;
                size = 1;
            }
        }

        if (maxSize < size) {
            maxSize = size;
        }

        return maxSize;
    }

}

package com.javadroider.interviewprep.companies;

public class FairIndex {

    public static void main(String[] args) {
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 5, 0, 3};
        new FairIndex().fairIndexes(A, B, A.length);
    }

    int fairIndexes(int[] A, int[] B, int length) {
        int[] sumA = new int[length + 1];
        int[] sumB = new int[length + 1];
        for (int index = 1; index <= length; index++) {
            sumA[index] = sumA[index - 1] + A[index - 1];
            sumB[index] = sumB[index - 1] + B[index - 1];
        }
        int noOfFairIndices = 0;
        for (int index = 1; index < length; index++) {
            // all possible indexes check if sum is same for all four sub arrays
            if (sumA[index] == sumB[index] &&
                    sumA[index] == sumA[length] - sumA[index] &&
                    sumB[index] == sumB[length] - sumB[index]) {
                System.out.println(index);
                return index;
            }
        }
        return noOfFairIndices;
    }
}

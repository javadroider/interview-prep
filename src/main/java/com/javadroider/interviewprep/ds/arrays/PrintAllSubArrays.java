package com.javadroider.interviewprep.ds.arrays;

//https://algorithms.tutorialhorizon.com/print-all-subarrays-of-a-given-array/
public class PrintAllSubArrays {

    public void printSubArrays(int[] arrA) {

        int arrSize = arrA.length;
        // start point
        for (int startPoint = 0; startPoint < arrSize; startPoint++) {
            // group sizes
            for (int grps = startPoint; grps <= arrSize; grps++) {
                // if start point = 1 then
                // grp size = 1 , print 1
                // grp size = 2, print 1 2
                // grp size = 3, print 1 2 3 ans so on
                for (int j = startPoint; j < grps; j++) {
                    System.out.print(arrA[j] + " ");
                }
                System.out.println();
            }
        }
    }

    //https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
    static void printSubsets(int set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        int[] arrA = {1, 2, 3};
        printSubsets(arrA);
        new PrintAllSubArrays().printSubArrays(arrA);
    }

}
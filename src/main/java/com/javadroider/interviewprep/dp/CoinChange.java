package com.javadroider.interviewprep.dp;

import java.util.Arrays;

public class CoinChange {

    private static int vk(int coins[], int total) {
        int rows = coins.length + 1;
        int cols = total + 1;
        int dp[][] = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                } else if (row == 0) {
                    dp[row][col] = 0;
                } else if (row > col) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - row];
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(dp[row][col] + " ");
            }
            System.out.println();
        }
        return dp[rows - 1][cols - 1];
    }

    private static int gfg(int coins[], int sizeOfArray, int total) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[total + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = coins[i]; j <= total; j++) {
                int current = table[j];
                int coinI = coins[i];
                int index = j - coinI;
                int temp = table[index];
                table[j] = current + temp;
            }
        }
        Arrays.stream(table).forEach(ele -> System.out.print(ele + " "));
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int amt = 1; amt < table.length; amt++) {
                if (amt - coins[i] >= 0)
                    table[amt] = table[amt] +  table[amt - coins[i]];
            }
        }
        System.out.println();
        Arrays.stream(table).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
        return table[total];
    }

    // Driver Function to test above function
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int sizeOfArray = arr.length;
        int total = 4;
        System.out.println(gfg(arr, sizeOfArray, total));
       // System.out.println(vk(arr, total));
    }
}

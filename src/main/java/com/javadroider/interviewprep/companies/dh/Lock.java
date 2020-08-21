package com.javadroider.interviewprep.companies.dh;

public class Lock {
    /**
     * Given are two strings, both of length N. The characters are digits ranging from “1” to “9”. The first string is the current state of a bike's combination lock and the other describes the needed combination for opening the lock.
     * <p>
     * Please write a function returning the smallest number of turns needed, until the bicycle lock becomes open.
     */
    public static void main(String[] args) {


        // please feel free to change anything you want and come up
        // with your own structure and test calls

    /*

      "123" "223" 1 < replace
      "123" "123" 0
      "
      currentState = "8754"
      neededState "4587"
      8>4 (8-4) 4
      7>5 (7-5) 2
      5>8 (5-8) 3
      4>7 (4-7) 3 4 + 2+ 3+ 3

      currentState = "8754"
      neededState "8587"

      2+3+3

      currentState = "8751"
      neededState "8759"

      9 - 1 1 or 8
      8 - 2 3 or 6

      9 + 1 = 10 % 9 = 1
      8 + 2 = 10 % 9
      min(10-9, 9 - 1) = 1
      min(10-2, 8-2) = 6
      min(

      9 - 1 = 8
      9 - 8 = 1

      8 - 2 = 6
      9 - 6 = 3

    */

        String currentState = "223";
        String neededState = "123";

        int count = 0;
        for (int i = 0; i < currentState.length(); i++) {

            if (currentState.charAt(i) != neededState.charAt(i)) {
                int one = currentState.charAt(i) - '0';
                int two = neededState.charAt(i) - '0';

                count += Math.abs(one - two);

            }
        }

    }
}

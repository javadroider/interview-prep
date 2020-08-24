package com.javadroider.interviewprep.leetcode.medium;

public class _670 {

    public static void main(String[] args) {
        int n1 = 12335431;
        int n2 = 49658;
        int n3 = 2135;
        int n4 = 5132;
        int n5 = 123;
        int num = n5;

        System.out.println(new _670().maximumSwap1(num));
        System.out.println(new _670().maximumSwap2(num));
        //12335431 52331431
        //49658 94658
        //2135 5132
    }

    //https://leetcode.com/problems/maximum-swap/discuss/107073/C%2B%2B-one-pass-simple-and-fast-solution%3A-1-3ms-O(n)-time
    public int maximumSwap2(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIndex = chars.length - 1;
        int x = 0, y = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[maxIndex] == chars[i]) {
                continue;
            }

            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            } else {
                x = maxIndex;
                y = i;
            }
        }

        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;

        return Integer.valueOf(new String(chars));
    }

    //https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
    public int maximumSwap1(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }

    //https://www.geeksforgeeks.org/largest-number-with-one-swap-allowed/
    public int maximumSwap(int num) {
        int maxDigit = -1;
        int maxDigitIndx = -1;
        int lIndx = -1;
        int rIndx = 0;

        // converting the number to string
        String numInStr = String.valueOf(num);
        for (int i = numInStr.length() - 2; i >= 0; i--) {
            // current digit is the largest by far
            if (numInStr.charAt(rIndx) > maxDigit) {
                maxDigit = numInStr.charAt(i);
                maxDigitIndx = i;
                continue;
            }

            // best digit for swap if there is no more
            // such situation on the left side
            if (numInStr.charAt(i) < maxDigit) {
                lIndx = i;
                rIndx = maxDigitIndx;
            }
        }

        // check for is number already in order
        if (lIndx == -1)
            return num;

        numInStr = swap(numInStr, lIndx, rIndx);

        return Integer.parseInt(numInStr);
    }

    private String swap(String arr, int i, int j) {
        char[] temp = arr.toCharArray();
        char c = temp[i];
        temp[i] = temp[j];
        temp[j] = c;
        return String.valueOf(temp);
    }
}

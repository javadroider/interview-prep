package com.javadroider.interviewprep.companies;

public class NumberGreaterThanN {

    public static void main(String[] args) {
        int n = 28;
        int sum = getSum(n);
        System.out.println(sum);
        while (n < Integer.MAX_VALUE){
            n++;
            int tempSum = getSum(n);
            if(tempSum == sum){
                System.out.println(n);
                break;
            }
        }

    }

    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

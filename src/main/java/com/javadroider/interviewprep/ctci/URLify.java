package com.javadroider.interviewprep.ctci;

import java.util.Arrays;

public class URLify {
    public static void main(String[] args) {
        int originalLength = "Hello World".length();
        char str[] = "Hello World      ".toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < originalLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int newIndex = originalLength - 1 + spaceCount * 2;
        for (int index = originalLength - 1; index >= 0; index--) {
            if (str[index] == ' ') {
                str[newIndex--] = '0';
                str[newIndex--] = '2';
                str[newIndex--] = '%';
            } else {
                str[newIndex--] = str[index];
            }
        }
        System.out.println(Arrays.toString(str));
    }
}

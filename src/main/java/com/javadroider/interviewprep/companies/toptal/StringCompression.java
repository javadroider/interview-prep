package com.javadroider.interviewprep.companies.toptal;

public class StringCompression {

    public static void main(String[] args) {
        String str1 = "ABBBCCDDCCC";
        String str = "ABCDDDEFG";
        int k = 2;
        System.out.println(solution(str, k));
    }

    public static int solution(String S, int k) {
        int ret = compress(S).length();
        for (int i = 0; i < S.length() - (k - 1); i++) {
            String subString = getSubstring(S, i, i + k - 1);
            ret = Math.min(ret, compress(subString).length());
        }
        return ret;
    }

    public static String getSubstring(String S, int begin, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            if (i < begin || i > end) {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int count = 0;
        while (i < str.length() - 1) {
            count++;
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (count > 1) {
                    result.append(count).append(str.charAt(i));
                } else {
                    result.append(str.charAt(i));
                }
                count = 0;
            }
            i++;
        }
        result.append(count + 1).append(str.charAt(i));
        System.out.println(result);
        return result.toString();
    }


    private static String compress1(String str) {
        //"ABBBCCCC";
        Character prev = str.charAt(0);
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < str.length(); i++) {
            Character current = str.charAt(i);
            int compare = current.compareTo(prev);
            if (compare != 0) {
                if (count != 0) {
                    sb.append(count).append(prev);
                } else {
                    sb.append(prev);
                }
                count = 0;
            } else {
                count++;
            }
            prev = current;
        }

        return sb.toString();
    }
}

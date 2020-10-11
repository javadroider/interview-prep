package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _0093_RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(new _0093_RestoreIPAddresses().restoreIpAddresses("25525511135"));
        System.out.println(new _0093_RestoreIPAddresses().restoreIpAddresses("010010"));
    }

    //https://leetcode.com/problems/restore-ip-addresses/discuss/30972/WHO-CAN-BEAT-THIS-CODE/29843
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    int d = len - a - b - c;
                    if (d > 0 && d <= 3) {
                        int A = Integer.parseInt(s.substring(0, a));
                        int B = Integer.parseInt(s.substring(a, a + b));
                        int C = Integer.parseInt(s.substring(a + b, a + b + c));
                        int D = Integer.parseInt(s.substring(a + b + c));
                        if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                            StringBuilder ip = new StringBuilder();
                            ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            if (ip.length() == len + 3) {//to handle "010010"
                                //without this 0.1.0.10 will pass
                                res.add(ip.toString());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}

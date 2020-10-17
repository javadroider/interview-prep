package com.javadroider.interviewprep.leetcode.easy;

public class _0157_ReadNCharactersGivenRead4 {


    public class Reader4 {
        int read4(char[] buf4) {
            return 1;
        }
    }

    //https://leetcode.com/problems/read-n-characters-given-read4/solution/
    public class Solution extends Reader4 {
        public int read(char[] buf, int n) {
            int copiedChars = 0;
            int readChars = 4;
            char[] buf4 = new char[4];

            while (copiedChars < n && readChars == 4) {
                readChars = read4(buf4);

                for (int i = 0; i < readChars; ++i) {
                    if (copiedChars == n)
                        return copiedChars;
                    buf[copiedChars] = buf4[i];
                    ++copiedChars;
                }
            }
            return copiedChars;
        }
    }
}

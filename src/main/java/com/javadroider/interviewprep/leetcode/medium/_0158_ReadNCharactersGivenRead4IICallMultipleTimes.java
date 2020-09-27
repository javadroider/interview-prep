package com.javadroider.interviewprep.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _0158_ReadNCharactersGivenRead4IICallMultipleTimes {

    public class Reader4 {
        int read4(char[] buf4) {
            return 1;
        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        private Queue<Character> queue = new LinkedList<>();

        public int read(char[] buf, int n) {

            int index = 0;
            while (queue.size() < n) {
                index = 0;
                char[] buf4 = new char[4];
                int ret = read4(buf4);
                if (ret == 0) {
                    break;
                }
                while (index < ret) {
                    queue.offer(buf4[index++]);
                }
            }

            index = 0;
            while (!queue.isEmpty() && index < n) {
                buf[index++] = queue.poll();
            }

            return index;
        }
    }
}

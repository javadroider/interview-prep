package com.javadroider.interviewprep.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _0253_MeetingRoomsII {


    /*

    Complexity Analysis

    Time Complexity: O(Nlog⁡N)O(N\log N)O(NlogN).
    There are two major portions that take up time here. One is sorting of the array that takes
    O(Nlog⁡N)O(N\log N)O(NlogN) considering that the array consists of NNN elements.
    Then we have the min-heap. In the worst case, all NNN meetings will collide with each other.
    In any case we have NNN add operations on the heap. In the worst case we will have NNN extract-min operations
    as well. Overall complexity being (NlogN)(NlogN)(NlogN) since extract-min operation on a heap
    takes O(log⁡N)O(\log N)O(logN).

    Space Complexity: O(N)O(N)O(N) because we construct the min-heap and that can contain NNN elements in the
    worst case as described above in the time complexity section. Hence, the space complexity is O(N)O(N)O(N).


     */
    //https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
    public int minMeetingRooms(int[][] intervals) {

        /*
            Input: [[0, 30],[5, 10],[15, 20]]
            Output: 2
         */
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval[1]);
                count++;
            } else {
                if (interval[0] >= pq.peek()) {
                    pq.poll();
                } else {
                    count++;
                }
                pq.offer(interval[1]);
            }
        }

        return count;
    }
}

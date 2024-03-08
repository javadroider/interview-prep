package com.javadroider.interviewprep.blind75.week3;

import java.util.Arrays;

public class _0435_NonOverlappingIntervals {



    //https://www.youtube.com/watch?v=nONCGxWoUfM&ab_channel=NeetCode
    public int eraseOverlapIntervals(int[][] intervals) {

        //sort by 1st
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        int prevEnd = intervals[0][1];
        int count = 0;

        for(int i = 1; i < intervals.length; i++){

            //no overlap
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
            }else{
                //overlap
                count++;
                //keep interval with minimum interval and eliminate one with longer interval
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }
        return count;
    }
}

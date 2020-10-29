package com.javadroider.interviewprep.leetcode.medium;

public class _1344_AngleBetweenHandsOfAClock {

    public static void main(String[] args) {
        System.out.println(new _1344_AngleBetweenHandsOfAClock().angleClock(1, 40));
    }

    //https://leetcode.com/problems/angle-between-hands-of-a-clock/solution/
    public double angleClock(int hour, int minutes) {
        int oneMinAngle = 6;
        int oneHourAngle = 30;

        double minutesAngle = oneMinAngle * minutes;
        double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

        double diff = Math.abs(hourAngle - minutesAngle);
        System.out.println(diff);
        //for 1:40 -> diff will be 190, so ans should be 360-190 = 170
        return Math.min(diff, 360 - diff);
    }
}

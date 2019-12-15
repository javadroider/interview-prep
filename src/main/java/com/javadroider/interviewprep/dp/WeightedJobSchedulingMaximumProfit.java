package com.javadroider.interviewprep.dp;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int start;
    int end;
    int profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("(");
        sb.append(start).append(":").append(end).append(")").append("->").append(profit);
        return sb.toString();
    }
}

class EndTimeComparator implements Comparator<Job> {

    @Override
    public int compare(Job j1, Job j2) {
        if (j1.end <= j2.end) {
            return -1;
        } else {
            return 1;
        }
    }

}

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that
 * jobs in subset do not overlap.
 * Check https://youtu.be/AxQjrWiOdkE for explanation
 */
public class WeightedJobSchedulingMaximumProfit {

    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non overlapping job is greater
     * than profit till last job.
     *
     */
    public int maximum(Job[] jobs) {
        int T[] = new int[jobs.length];
        EndTimeComparator comparator = new EndTimeComparator();
        Arrays.sort(jobs, comparator);

        T[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            T[i] = jobs[i].profit;
            for (int j = 0; j < i; j++) {
                if (jobs[j].end <= jobs[i].start) {
                    T[i] = Math.max(T[i], jobs[i].profit + jobs[j].profit);
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(T));
        for (int val : T) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    public static void main(String args[]) {
        Job jobs[] = new Job[6];

        jobs[0] = new Job(1, 4, 3);
        jobs[1] = new Job(2, 6, 5);
        jobs[2] = new Job(4, 7, 2);
        jobs[3] = new Job(6, 8, 6);
        jobs[4] = new Job(5, 9, 4);
        jobs[5] = new Job(7, 10, 8);

        WeightedJobSchedulingMaximumProfit mp = new WeightedJobSchedulingMaximumProfit();
        System.out.println(mp.maximum(jobs));
    }
}

package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0616_AddBoldTagInString {

    public static void main(String[] args) {
        System.out.println(new _0616_AddBoldTagInString().addBoldTag("abcxyz123", new String[]{"abc", "123"}));
        // System.out.println(new _0616_AddBoldTagInString().addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"}));
    }

    //https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array/149578
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (String word : dict) {
            int start = 0;
            while (start >= 0) {
                start = s.indexOf(word, start);
                if (start < 0) {
                    break;
                }
                int end = start + word.length();
                for (int i = start; i < end; i++) {
                    bold[i] = true;
                }
                start++; // Just start from next index, instead of iterating through entire string
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i)); // Just go character by character rather than cutting up the string
            if (bold[i] && (i + 1 == s.length() || !bold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    ////https://leetcode.com/problems/add-bold-tag-in-string/discuss/104263/Java-solution-Same-as-Merge-Interval.
    public String addBoldTag1(String s, String[] dict) {

        int index = -1;
        List<Interval> intervals = new ArrayList<>();

        for (String word : dict) {
            index = s.indexOf(word, index);
            while (index != -1) {
                intervals.add(new Interval(index, index + word.length()));
                index++;
                index = s.indexOf(word, index);
            }
        }
        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            prev = interval.end;
        }

        if (prev < s.length()) {
            sb.append(s.substring(prev));
        }

        return sb.toString();
    }

    private List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> res = new ArrayList<>();
        Interval current = intervals.get(0);
        res.add(current);
        //{1,3}{2,4}{5,8} -> {1,4}
        for (Interval interval : intervals) {
            if (current.end >= interval.start) {
                current.end = Math.max(current.end, interval.end);
            } else {
                current = interval;
                res.add(current);
            }
        }

        return res;
    }


    private class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
    /*
    //https://leetcode.com/problems/add-bold-tag-in-string/discuss/104263/Java-solution-Same-as-Merge-Interval.
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for (String str : dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while (index != -1) {
                intervals.add(new Interval(index, index + str.length()));
                index += 1;
                index = s.indexOf(str, index);
            }
        }
        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            prev = interval.end;
        }
        if (prev < s.length()) {
            sb.append(s.substring(prev));
        }
        return sb.toString();
    }

    class Interval {
        int start, end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
    */
}

package org.algos.Greedy.IntervalsSchedulingAlgo;

//      Interval Scheduling is a greedy algorithm used to select the maximum
//      number of non-overlapping intervals from a given set of intervals.
//      The strategy is to always pick the interval that finishes earliest,
//      leaving maximum room for future intervals.
//
//       Algorithm Explanation
//
//      Sort all intervals by ending time.
//
//      Pick the first interval (earliest finish).
//
//      For each next interval:
//
//      Select it only if its start ≥ last selected end.
//
//      Count all selected intervals.
//
//      Greedy choice works because choosing the earliest finishing
//      interval gives the most flexibility.

import java.io.*;
import java.util.*;

class Main {

    static class Interval {
        int s;
        int e;

        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        Interval[] a = {
                new Interval(1, 3),
                new Interval(2, 4),
                new Interval(3, 5),
                new Interval(0, 6)
        };

        Arrays.sort(a, (x, y) -> x.e - y.e);

        int cnt = 1;
        int lastEnd = a[0].e;

        for (int i = 1; i < a.length; i++) {
            if (a[i].s >= lastEnd) {
                cnt++;
                lastEnd = a[i].e;
            }
        }

        System.out.println(cnt);
    }
}
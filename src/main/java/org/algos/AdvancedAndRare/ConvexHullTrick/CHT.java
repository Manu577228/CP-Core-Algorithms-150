package org.algos.AdvancedAndRare.ConvexHullTrick;

//          Convex Hull Trick (CHT) is an optimization technique used in
//          Dynamic Programming to efficiently compute
//          minimum/maximum values of linear functions.
//          It maintains a set of lines
//          y=mx+c and answers queries like:
//
//          “What is the minimum (or maximum) value at a given x?”
//
//      Time improves from O(N²) to O(N) or O(N log N) depending on implementation.


//        Algorithm Explanation
//
//         We maintain a set of lines in order of slope.
//
//          When adding a new line:
//
//          If the previous line becomes useless (never gives better answer), remove it.
//
//          Use intersection comparison to check useless lines.
//
//      For query:
//
//      If queries are monotonic in x → move pointer forward.
//
//        Else → use binary search.
//
//          Key idea:
//
//      A line is useless if the intersection of (l1,l2) ≥ intersection of (l2,l3).

import java.io.*;
import java.util.*;

class Main {

    static class Line {
        long m;
        long c;

        Line(long m, long c) {
            this.m = m;
            this.c = c;
        }

        long value(long x) {
            return m * x + c;
        }
    }

    static class CHT {
        Line[] hull;
        int size;

        CHT(int n) {
            hull = new Line[n];
            size = 0;
        }

        boolean isBad(Line l1, Line l2, Line l3) {
            return (l3.c - l1.c) * (l1.m - l2.m)
                    <= (l2.c - l1.c) * (l1.m - l3.m);
        }

        void add(long m, long c) {
            Line newLine = new Line(m, c);

            while (size >= 2 &&
                    isBad(hull[size - 2], hull[size - 1], newLine)) {

                size--;
            }

            hull[size++] = newLine;
        }

        long query(long x) {
            int low = 0, high = size - 1;

            while (low < high) {
                int mid = (low + high) / 2;

                if (hull[mid].value(x) <= hull[mid + 1].value(x))
                    high = mid;
                else
                    low = mid + 1;
            }

            return hull[low].value(x);
        }
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        CHT cht = new CHT(100);

        cht.add(5, 2);
        cht.add(3, 8);
        cht.add(1, 10);

        long result = cht.query(4);

        out.println(result);
        out.flush();
    }
}

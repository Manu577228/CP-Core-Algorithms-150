package org.algos.AdvancedAndRare.RotatingCalipersAlgo;

//          Rotating Calipers is a geometric technique used on a convex polygon
//          to compute properties like diameter (farthest pair of points),
//          width, or minimum bounding rectangle.
//          It works by placing two parallel “calipers” on the
//          polygon and rotating them around the hull in linear time.


//          Algorithm Explanation
//
//          For finding diameter of convex hull:
//
//          Start with two points: one at the leftmost point and one at the
//          farthest opposite point.
//
//          Move the second pointer while the area formed increases.
//
//          At every step, compute distance between current pair.
//
//          Rotate pointers around hull once → total O(n).
//
//          Core Idea:
//          Each pointer moves at most one full cycle → linear processing.

import java.io.*;
import java.util.*;

class Main {

    static class P {
        long x, y;

        P(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static long dist2(P a, P b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;

        return dx * dx + dy * dy;
    }

    static long cross(P a, P b, P c) {
        return (b.x - a.x) * (c.y - a.y)
                - (b.y - a.y) * (c.x - a.x);
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        P[] p = new P[4];
        p[0] = new P(0, 0);
        p[1] = new P(2, 0);
        p[2] = new P(2, 2);
        p[3] = new P(0, 2);

        int n = p.length;
        int j = 1;
        long max = 0;

        for (int i = 0; i < n; i++) {
            int ni = (i + 1) % n;

            while (Math.abs(cross(p[i], p[ni], p[(j + 1) % n])) >
                    Math.abs(cross(p[i], p[ni], p[j]))) {
                j = (j + 1) % n;
            }

            long d = dist2(p[i], p[j]);
            if (d > max) max = d;
        }

        out.println(max);
        out.flush();
    }
}

package org.algos.Trees.SegmentTreeAlgo;

//        A Segment Tree is a binary tree used to efficiently
//        answer range queries (sum/min/max) on an array.
//        It supports both queries and updates in O(log n) time.

//           How the Algorithm Works
//
//        The array is recursively divided into segments
//
//        Each node stores information about a segment (e.g., sum of a range)
//
//        Root represents the entire array
//
//        Left child → left half, Right child → right half
//
//        Queries traverse only the relevant segments
//
//        Updates modify only affected nodes upward

//        Example Array: [1, 3, 5, 7, 9]
//        Operation: Range Sum Query

import java.io.*;
import java.util.*;

class SegmentTree {

    static int[] st;
    static int n;

    public static void build(int[] a, int i, int l, int r) {
        if (l == r) {
            st[i] = a[l];
            return;
        }

        int m = (l + r) / 2;

        build(a, 2 * i, l, m);
        build(a, 2 * i + 1, m + 1, r);
        st[i] = st[2 * i] + st[2 * i + 1];
    }

    public static int query(int i, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            return st[i];
        }

        int m = (l + r) / 2;

        int leftSum = query(2 * i, l, m, ql, qr);
        int rightSum = query(2 * i + 1, m + 1, r, ql, qr);

        return leftSum + rightSum;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {1, 3, 5, 7, 9};

        n = a.length;

        st = new int[4 * n];

        build(a, 1, 0, n - 1);

        int res = query(1, 0, n - 1, 1, 3);

        System.out.println(res);
    }
}

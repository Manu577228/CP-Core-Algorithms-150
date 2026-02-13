package org.algos.Trees.MergeSortTreeAlgo;

//A Merge Sort Tree is a segment tree where each node stores
//        a sorted list of elements from its segment.
//        It enables fast range queries involving order statistics (e.g., count ≤ X in a range).

//        How the Algorithm Works
//
//        Split the array using segment tree logic.
//
//        Each node represents a segment [l, r].
//
//        Leaf node → stores one element (already sorted).
//
//        Internal node → merge sorted arrays of its left and right children.
//
//        For a query:
//
//        Visit only nodes fully inside the range.
//
//        Use binary search on node’s sorted list to answer queries like count ≤ X.

import java.io.*;
import java.util.*;

class MergeSortTree {

    static int[] a;
    static int[][] t;

    static void build(int v, int l, int r) {
        if (l == r) {
            t[v] = new int[]{
                    a[l]
            };
            return;
        }

        int m = (l + r) >> 1;
        build(v << 1, l, m);
        build(v << 1 | 1, m + 1, r);

        int[] x = t[v << 1];
        int[] y = t[v << 1 | 1];
        t[v] = new int[x.length + y.length];

        int i = 0, j = 0, k = 0;
        while (i < x.length && j < y.length)
            t[v][k++] = (x[i] <= y[j]) ? x[i++] : y[j++];

        while (i < x.length) t[v][k++] = x[i++];
        while (j < y.length) t[v][k++] = y[j++];
    }

    static int query(int v, int l, int r, int ql, int qr, int x) {
        if (r < ql || l > qr) return 0;
        if (l >= ql && r <= qr) {
            return upperBound(t[v], x);
        }

        int m = (l + r) >> 1;
        return query(v << 1, l, m, ql, qr, x) +
                query(v << 1 | 1, m + 1, r, ql, qr, x);
    }

    static int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >> 1;
            if (arr[m] <= x) l = m + 1;
            else r = m;
        }

        return l;
    }

    public static void main(String[] args) {
        a = new int[]{1, 5, 2, 6, 3};
        int n = a.length;
        t = new int[4 * n][];

        build(1, 0, n - 1);

        int ans = query(1, 0, n - 1, 1, 3, 4);
        System.out.println(ans);
    }
}

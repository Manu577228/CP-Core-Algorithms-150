package org.algos.Trees.LazySegmentTreeAlgo;

//        Lazy Propagation Segment Tree is an optimized segment
//        tree technique used to delay range updates
//        so that each update/query runs in logarithmic time instead of linear time.

//           How the algorithm works
//
//        Segment Tree stores information (like sum/min/max) for array ranges
//
//        Range updates (add value to a range) are expensive if done directly
//
//        Lazy array stores pending updates for a node
//
//        When a node fully overlaps the update range:
//
//        Update node value
//
//        Store update in lazy[node]
//
//        Actual propagation to children happens only when required
//
//        This avoids repeated updates → huge performance gain

//            Example:
//        Array = [1, 2, 3, 4, 5]
//        Operation: Add +10 to range [1,3]
//        Query: Sum of range [0,4]

import java.io.*;
import java.util.*;


import java.io.*;
import java.util.*;

class LazyPropagationST {

    static int[] st;
    static int[] lazy;
    static int n;

    static void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            st[node] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(node << 1, l, mid, arr);
        build(node << 1 | 1, mid + 1, r, arr);
        st[node] = st[node << 1] + st[node << 1 | 1];
    }

    static void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            st[node] += (r - l + 1) * lazy[node];
            if (l != r) {
                lazy[node << 1] += lazy[node];
                lazy[node << 1 | 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int node, int l, int r, int ql, int qr, int val) {
        push(node, l, r);
        if (r < ql || l > qr) return;
        if (ql <= l && r <= qr) {
            lazy[node] += val;
            push(node, l, r);
            return;
        }
        int mid = (l + r) >> 1;
        update(node << 1, l, mid, ql, qr, val);
        update(node << 1 | 1, mid + 1, r, ql, qr, val);
        st[node] = st[node << 1] + st[node << 1 | 1];
    }

    static int query(int node, int l, int r, int ql, int qr) {
        push(node, l, r);
        if (r < ql || l > qr) return 0;
        if (ql <= l && r <= qr) return st[node];
        int mid = (l + r) >> 1;
        return query(node << 1, l, mid, ql, qr)
                + query(node << 1 | 1, mid + 1, r, ql, qr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        n = arr.length;
        st = new int[4 * n];
        lazy = new int[4 * n];
        build(1, 0, n - 1, arr);
        update(1, 0, n - 1, 1, 3, 10);
        System.out.println(query(1, 0, n - 1, 0, 4));
    }
}

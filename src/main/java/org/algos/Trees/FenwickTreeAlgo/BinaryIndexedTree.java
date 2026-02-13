package org.algos.Trees.FenwickTreeAlgo;

//A Fenwick Tree / Binary Indexed Tree (BIT) is a tree-based data structure
//        used to efficiently maintain prefix sums of an array.
//        It supports point updates and range queries in logarithmic time.

//         How the Algorithm Works
//
//        Internally uses a 1-indexed array
//
//        Each index stores the sum of a specific range
//
//        Range size depends on the rightmost set bit (LSB)
//
//        While updating:
//
//        Move forward using i += (i & -i)
//
//        While querying prefix sum:
//
//        Move backward using i -= (i & -i)
//
//        This forms an implicit tree structure inside an array

//Example Used
//
//        Array = [1, 2, 3, 4, 5]
//        Operations:
//
//        Build Fenwick Tree
//
//        Query prefix sum till index 4
//
//        Update index 3 by +2

import java.io.*;
import java.util.*;

class FenwickTreeDemo {

    static int n;
    static int[] bit;

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        n = arr.length;
        bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i + 1, arr[i]);
        }

        System.out.println(prefixSum(4));

        update(3, 2);

        System.out.println(prefixSum(4));

    }

    static void update(int i, int val) {
        while (i <= n) {
            bit[i] += val;
            i += (i & -i);
        }
    }

    static int prefixSum(int i) {
        int sum = 0;

        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }

        return sum;
    }
}


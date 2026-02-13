package org.algos.Arrays.PrefixSumAlgo;

//Prefix Sum is an array where each index stores the sum of
//all elements from index 0 to that index.
//It allows fast range sum queries after linear preprocessing.

//Algorithm Explanation
//
//Start with an input array a
//
//Create a prefix array p of same size
//
//p[0] = a[0]
//
//For every index i > 0
//        → p[i] = p[i-1] + a[i]
//
//Now:
//
//Sum of range [0 … r] = p[r]
//
//Sum of range [l … r] = p[r] - p[l-1]

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        int[] a = {2, 4, 6, 8};

        int n = a.length;

        int[] p = new int[n];

        p[0] = a[0];

        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + a[i];
        }

        int l = 1;
        int r = 3;

        int rangeSum = p[r] - p[l - 1];

        System.out.println(rangeSum);
    }
}
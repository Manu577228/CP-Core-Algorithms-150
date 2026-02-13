package org.algos.BitManipulation.SubsetEnumerationAlgo;

//        Subset Enumeration using Bits is a technique
//        where each number from 0 to (2^n − 1) represents one subset.
//        Each bit decides whether an element is included (1) or excluded (0).
//
//            Algorithm Explanation
//
//        If an array has n elements, total subsets = 2^n
//
//        Numbers from 0 to 2^n - 1 cover all bit combinations
//
//        For each number:
//
//        Check every bit position
//
//        If bit is 1, include that element in subset
//
//        Repeat until all numbers are processed

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int[] a = {1, 2, 3};
        int n = a.length;

        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            out.print("{ ");

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    out.print(a[i] + " ");
                }
            }

            out.println("}");
        }

        out.flush();
    }
}
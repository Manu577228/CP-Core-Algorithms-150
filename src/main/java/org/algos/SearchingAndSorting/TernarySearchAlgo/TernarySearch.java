package org.algos.SearchingAndSorting.TernarySearchAlgo;

//          Ternary Search is a divide-and-conquer searching
//          algorithm that works on a sorted array by dividing the search
//          space into three parts instead of two.
//          At every step, it compares the target with two mid
//          points and discards two-thirds of the array accordingly.


//          Algorithm Explanation
//
//          Maintain low and high pointers.
//
//          Compute two mid points:
//
//          mid1 = low + (high - low) / 3
//
//          mid2 = high - (high - low) / 3
//
//          Compare target with mid1 and mid2.
//
//          Narrow the search to one of three regions.
//
//          Repeat until found or search space becomes invalid.

import java.io.*;

class Main {

    static int ternarySearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int m1 = l + (r - l) / 3;
            int m2 = r - (r - l) / 3;

            if (a[m1] == x)
                return m1;

            if (a[m2] == x)
                return m2;

            if (x < a[m1])
                r = m1 - 1;

            else if (x > a[m2])
                l = m2 + 1;

            else {
                l = m1 + 1;
                r = m2 - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10, 12, 14};
        int x = 10;

        int idx = ternarySearch(a, x);

        System.out.println(idx);
    }
}
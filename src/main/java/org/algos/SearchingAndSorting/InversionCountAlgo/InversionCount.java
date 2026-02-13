package org.algos.SearchingAndSorting.InversionCountAlgo;

//      Inversion Count is the number of index pairs (i, j)
//      such that i < j and arr[i] > arr[j].
//      It measures how far an array is from being sorted.
//      A fully sorted array has 0 inversions.


//      Algorithm Explanation
//
//      Use Merge Sort idea.
//
//      While merging two sorted halves:
//
//      If left element ≤ right → no inversion.
//
//      If left element > right → all remaining left elements form inversions.
//
//      Sum these counts during merge steps.

import java.io.*;
import java.util.*;

class Main {

    static long cnt;

    static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = a[l + i];

        for (int j = 0; j < n2; j++)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
                cnt += (n1 - i);
            }
        }

        while (i < n1)
            a[k++] = L[i++];

        while (j < n2)
            a[k++] = R[j++];
    }

    static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int[] a = {8, 4, 2, 1};
        cnt = 0;

        mergeSort(a, 0, a.length - 1);

        out.println(cnt);
        out.flush();
    }
}

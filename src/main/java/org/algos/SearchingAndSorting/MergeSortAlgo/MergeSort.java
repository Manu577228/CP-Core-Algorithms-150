package org.algos.SearchingAndSorting.MergeSortAlgo;

//          Merge Sort is a divide-and-conquer sorting algorithm that recursively
//          splits the array into halves, sorts each half, and then merges them back
//          in sorted order.
//          It guarantees O(N log N) time complexity regardless of input order.


//          Algorithm Explanation
//
//          Divide the array into two halves until each subarray has one element
//
//          Merge two sorted halves by comparing elements one by one
//
//          Repeat merging until the entire array is sorted

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {5, 2, 4, 1, 3};

        mergeSort(arr, 0, arr.length - 1);

        for (int x : arr)
            out.print((x + " "));

        out.println();
        out.flush();
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int m = l + (r - l) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < n1)
            arr[k++] = left[i++];

        while (j < n2)
            arr[k++] = right[j++];
    }
}
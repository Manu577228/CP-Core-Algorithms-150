package org.algos.SearchingAndSorting.RadixSortAlgo;

//          Radix Sort is a non-comparison sorting algorithm that sorts
//          numbers digit by digit, starting from the least significant digit to
//          the most significant digit.
//          It uses a stable sub-sorting technique (usually Counting Sort)
//          at each digit place.


//         Algorithm Explanation
//
//          Find the maximum number to know how many digit places exist
//
//          For each digit place (1, 10, 100, …):
//
//          Group numbers based on the current digit
//
//          Rebuild the array using stable counting sort
//
//          Repeat until all digit places are processed

import java.io.*;
import java.util.*;

class Main {

    static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(arr);

        for (int x : arr) {
            out.print(x + " ");
        }

        out.flush();
    }
}

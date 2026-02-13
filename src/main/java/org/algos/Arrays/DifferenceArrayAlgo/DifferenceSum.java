package org.algos.Arrays.DifferenceArrayAlgo;

//A Difference Array stores changes between consecutive elements instead of actual values.
//It allows fast range updates by updating only two positions.

//Algorithm Explanation
//
//Start with an array arr of size n
//
//Build a difference array diff where
//diff[i] = arr[i] - arr[i-1]
//
//To add val to range [l, r]
//
//Do diff[l] += val
//
//Do diff[r + 1] -= val (if inside bounds)
//
//After all updates, prefix sum of diff gives final array

import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int n = 5;
        int[] arr = {10, 10, 10, 10, 10};

        int[] diff = new int[n + 1];

        diff[0] = arr[0];

        for (int i = 1; i < n; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }

        int l = 1, r = 3, val = 5;

        diff[l] += val;
        diff[r + 1] -= val;

        int[] res = new int[n];

        res[0] = diff[0];

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        for (int x : res) out.print(x + " ");

        out.flush();
    }
}
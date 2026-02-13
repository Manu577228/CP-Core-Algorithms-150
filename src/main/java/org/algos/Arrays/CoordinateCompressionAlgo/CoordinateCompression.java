package org.algos.Arrays.CoordinateCompressionAlgo;

//Coordinate Compression replaces large or arbitrary
//values in an array with their rank positions after sorting unique values,
//while preserving order relationships.

//Algorithm Explanation
//
//Copy the original array into a temporary array
//
//Sort the temporary array
//
//Remove duplicates from the sorted array
//
//For each original element, find its index in the unique sorted array
//
//That index is the compressed coordinate

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {100, 500, 100, 200};
        int n = arr.length;

        int[] temp = arr.clone();
        Arrays.sort(temp);

        int[] uniq = new int[n];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || temp[i] != temp[i - 1]) {
                uniq[m++] = temp[i];
            }
        }

        int[] comp = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(uniq, 0, m, arr[i]);
            comp[i] = idx;
        }

        for (int x : comp) out.print(x + " ");
        out.println();

        out.flush();
    }
}
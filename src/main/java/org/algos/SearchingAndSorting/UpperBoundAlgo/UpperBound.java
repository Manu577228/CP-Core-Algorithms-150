package org.algos.SearchingAndSorting.UpperBoundAlgo;

//          Upper Bound finds the first index where the element
//          is strictly greater than a given target in a sorted array.
//          If no such element exists, it returns the array length.
//          It is efficiently implemented using Binary Search.


//          Algorithm Explanation
//
//          Maintain two pointers low and high
//
//          Search space always keeps possible upper bound indices
//
//          If arr[mid] > target, move left to find earlier valid index
//
//          Else, move right
//
//          Final low gives the upper bound position

import java.io.*;
import java.util.*;

class Main {

    static int upperBound(int[] arr, int n, int target) {
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {1, 2, 4, 4, 5, 7};
        int target = 4;

        int index = upperBound(arr, arr.length, target);

        out.println(index);
        out.flush();

    }
}
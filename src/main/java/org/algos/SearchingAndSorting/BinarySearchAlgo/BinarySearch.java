package org.algos.SearchingAndSorting.BinarySearchAlgo;

//      Binary Search is a searching algorithm used on sorted arrays.
//      It repeatedly divides the search space into half, eliminating one half each time.
//      This reduces the search time drastically compared to linear search.


//   Algorithm Explanation
//
//      Work only on a sorted array
//
//      Compare the target with the middle element
//
//      If equal → found
//
//      If smaller → search left half
//
//      If larger → search right half
//
//      Repeat until found or search space ends


import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72};

        int target = 23;

        int l = 0;
        int r = arr.length - 1;

        int idx = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == target) {
                idx = m;
                break;
            }

            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        out.println(idx);
        out.flush();
    }
}
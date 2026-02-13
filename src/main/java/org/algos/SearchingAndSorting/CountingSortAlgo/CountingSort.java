package org.algos.SearchingAndSorting.CountingSortAlgo;

//          Counting Sort is a non-comparison based sorting algorithm that
//          sorts elements by counting the frequency of each value within a known range.
//          It works best when the range of values is small compared
//          to the number of elements.
//
//          Algorithm Explanation
//
//          Find the maximum value in the array.
//
//          Create a count array to store frequency of each value.
//
//          Convert the count array into sorted output by placing values
//          based on their counts.

import java.io.*;
import java.util.*;

class CountingSortDemo {
    public static void main(String[] args) throws Exception {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[idx] = i;
                idx++;
                count[i]--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
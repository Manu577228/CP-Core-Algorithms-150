package org.algos.Arrays.KadanesAlgo;

//Kadane’s Algorithm finds the maximum sum of a contiguous subarray in a given integer array.
//It works in linear time by deciding at each index whether
//to extend the current subarray or start fresh.

//How the Algorithm Works :
//
//Maintain two variables:
//
//currSum → maximum subarray sum ending at current index
//
//maxSum → maximum subarray sum found so far
//
//For each element:
//
//Either extend the previous subarray (currSum + a[i])
//
//Or start new subarray from current element (a[i])
//
//Update maxSum whenever currSum becomes larger
//
//Final maxSum is the answer

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {-2, 1, -3, 4, -1, 2, 1};

        int currSum = a[0];
        int maxSum = a[0];

        for (int i = 1; i < a.length; i++) {
            currSum = Math.max(a[i], currSum + a[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);
    }
}
package org.algos.DynamicProgramming.LongestIncreasingSubsequenceAlgo;

//        Longest Increasing Subsequence (LIS) is a sequence derived from an array such that:
//
//        The elements are strictly increasing
//
//        The sequence maintains original order
//
//        The goal is to find the maximum possible length of such a subsequence

//       Algorithm Explanation
//
//        Use Dynamic Programming
//
//        Let dp[i] = length of LIS ending at index i
//
//        For every element, look back at all previous smaller elements and
//        update the best possible LIS ending at i
//
//        The maximum value in dp[] is the answer

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
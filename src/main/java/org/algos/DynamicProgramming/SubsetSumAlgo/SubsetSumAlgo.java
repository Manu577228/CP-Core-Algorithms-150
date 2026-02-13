package org.algos.DynamicProgramming.SubsetSumAlgo;

//Subset Sum is a Dynamic Programming problem where we check
// whether a subset of given numbers can form a target sum.
//It uses state transitions to decide inclusion or exclusion of elements.
//The problem is typically solved using a boolean DP table.
//
//          Algorithm Explanation
//
//          Use a DP table where dp[i][j] means:
//          Using first i elements, can we form sum j?
//
//          Initialize base cases:
//
//          Sum 0 is always possible (empty subset)
//
//          Positive sum with 0 elements is impossible
//
//          For each element:
//
//          Either exclude it
//
//          Or include it (if value ≤ current sum)
//
//          Final answer is stored in dp[n][target]

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        PrintWriter out = new PrintWriter(System.out);

        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        out.println(dp[n][target]);
        out.flush();

    }
}
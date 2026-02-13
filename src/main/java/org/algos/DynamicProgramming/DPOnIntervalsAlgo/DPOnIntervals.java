package org.algos.DynamicProgramming.DPOnIntervalsAlgo;

//      DP on Intervals is a dynamic programming technique where we solve
//      problems by computing optimal answers for all subarrays/subintervals and
//      then combining them to solve larger intervals.
//      The DP state usually represents the answer for an interval [l, r], and
//      transitions try all possible partition points inside that interval.
//
//      Algorithm Explanation
//
//      Define dp[l][r] as the minimum cost to solve the interval from l to r
//
//      Length of interval increases from small to large
//
//      For every interval [l, r], try splitting at every k where l ≤ k < r
//
//      Choose the minimum among all possible splits

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] a = {10, 20, 30, 40};
        int n = a.length;

        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int l = 1; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    int cost = dp[l][k] + dp[k + 1][r] + a[l - 1] * a[k] * a[r];
                    dp[l][r] = Math.min(dp[l][r], cost);
                }
            }
        }

        out.println(dp[1][n - 1]);
        out.flush();
    }
}

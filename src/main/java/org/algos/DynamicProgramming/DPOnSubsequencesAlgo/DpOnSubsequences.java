package org.algos.DynamicProgramming.DPOnSubsequencesAlgo;

//      DP on subsequences is a dynamic programming technique where we compute
//      optimal results for all subsequences ending at each index.
//      Each DP state represents the best answer considering elements up to that
//        position, following a specific rule (increase, decrease, match, etc.).
//
//        Algorithm Explanation
//
//      Fix each element as the ending point of a subsequence
//
//      Try to extend previous valid subsequences
//
//      Store the best result ending at every index
//
//      The final answer is the maximum over all DP states


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] a = {10, 9, 2, 5, 3, 7};

        int n = a.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        out.println(ans);
        out.flush();
    }
}

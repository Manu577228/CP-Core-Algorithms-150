package org.algos.DynamicProgramming.Knapsack01Algo;

//        0/1 Knapsack is a dynamic programming algorithm used to maximize
//        total value in a knapsack of fixed capacity, where each item can be
//        chosen either once or not at all.
//        Each item has a weight and a value, and the goal is optimal selection
//        under capacity constraints.
//
//         Algorithm Explanation
//
//        Use DP where dp[i][w] = maximum value using first i items with capacity w
//
//        For each item:
//
//        Either exclude it → value stays same
//
//        Or include it (if weight allows) → add its value
//
//        Final answer is dp[n][W]

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 3;
        int W = 4;

        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println(dp[n][W]);
        out.flush();

    }
}
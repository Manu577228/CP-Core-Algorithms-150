package org.algos.DynamicProgramming.UnboundedKnapsackAlgo;

//Unbounded Knapsack is a Dynamic Programming problem where each item can be chosen unlimited times.
//The goal is to maximize total value without exceeding the knapsack’s capacity.
//
//   Algorithm Explanation
//
//          Use 1D DP where dp[w] = maximum value achievable with capacity w.
//
//          For each capacity, try taking every item again (since unbounded).
//
//          Transition:
//          dp[w] = max(dp[w], dp[w - weight[i]] + value[i])

class Main {
    public static void main(String[] args) {
        int n = 2;
        int W = 7;

        int[] wt = {2, 3};
        int[] val = {10, 15};

        int[] dp = new int[W + 1];

        for (int w = 0; w <= W; w++) {
            for (int i = 0; i < n; i++) {
                if (w >= wt[i]) {
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
                }
            }
        }

        System.out.println(dp[W]);
    }
}
package org.algos.DynamicProgramming.FibonacciDPAlgo;

//          Fibonacci using DP computes the nth Fibonacci number by storing
//          results of smaller subproblems so that each value is calculated only once.
//          It eliminates repeated recursive calls by building the solution from base cases upward.

//          Algorithm Explanation
//
//          Fibonacci follows: F(n) = F(n-1) + F(n-2)
//
//          Store results in a DP array to avoid recomputation
//
//          Start from base cases (0 and 1) and build up to n

class FibonacciDP {
    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
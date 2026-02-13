package org.algos.DynamicProgramming.MatrixChainMultiplicationAlgo;

//Matrix Chain Multiplication is a Dynamic Programming algorithm used
// to find the minimum number of scalar multiplications needed to multiply a chain of matrices.
//The order of multiplication is optimized without changing the final result.

//      Algorithm Explanation

//      Given matrix dimensions array arr[] where matrix i has size arr[i-1] x arr[i]
//
//      Use DP where dp[i][j] stores the minimum cost to multiply matrices from i to j
//
//      Try all possible split points k between i and j, and take the minimum cost

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int l = 2; l < n; l++) {
            for (int i = 1; i + l - 1 < n; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] +
                            dp[k + 1][j] +
                            arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[1][n - 1]);
    }
}
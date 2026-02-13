package org.algos.DynamicProgramming.MemoizationAlgo;

//Memoization is a Dynamic Programming technique where we store results of
//already solved subproblems to avoid recomputation, reducing exponential
//recursion into linear time.

//        Algorithm Explanation
//
//          Break the problem into overlapping subproblems
//
//          Store each computed result in a DP array
//
//        Before computing, check if the value already exists
//
//          Return stored value instead of recomputing

import java.io.*;
import java.util.*;

class Main {

    static int[] dp;

    static int fib(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        dp[n] = fib(n - 1) + fib(n - 2);

        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = 6;

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        int result = fib(n);

        out.println(result);

        out.flush();
    }
}

package org.algos.DynamicProgramming.DigitDPAlgo;

//      Digit DP is a dynamic programming technique used to solve problems on
//      numbers by processing them digit by digit.
//      It efficiently counts or optimizes values over a range of numbers
//      while respecting constraints like digit sum, digit count, or limits.
//
//      Algorithm Explanation
//
//      Convert the number N into digits.
//
//      Build the number left to right using DP.
//
//      At each digit:
//
//        Track position, tight constraint (≤ N), and required state (like digit sum).
//
//      Use memoization to avoid recomputation.
//
//        The final DP value gives the answer.


import java.io.*;
import java.util.*;

class Main {

    static char[] d;
    static int S;
    static int[][][] dp;

    static int f(int i, int sum, int tight) {
        if (sum > S) return 0;

        if (i == d.length)
            return sum == S ? 1 : 0;

        if (dp[i][sum][tight] != -1)
            return dp[i][sum][tight];

        int lim = (tight == 1) ? d[i] - '0' : 9;
        int res = 0;

        for (int dig = 0; dig <= lim; dig++) {
            res += f(
                    i + 1,
                    sum + dig,
                    (tight == 1 && dig == lim) ? 1 : 0
            );
        }

        return dp[i][sum][tight] = res;
    }

    public static void main(String[] args) {
        String N = "25";
        S = 3;

        d = N.toCharArray();
        dp = new int[d.length][S + 1][2];

        for (int[][] x : dp)
            for (int[] y : x)
                Arrays.fill(y, -1);

        int ans = f(0, 0, 1);
        System.out.println(ans);
    }
}


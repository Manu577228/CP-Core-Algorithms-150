package org.algos.MathORNumberTheory.CatalanNumbersAlgo;

//        Catalan Numbers count the number of ways to correctly form
//        structures like balanced parentheses, BSTs, or polygon triangulations.
//
//        The nth Catalan number is defined as
//        C(n) = (1 / (n + 1)) · (2n choose n)

//          Algorithm Explanation
//
//        Use Dynamic Programming
//
//        Let dp[i] store the i-th Catalan number
//
//        Base cases:
//
//        dp[0] = 1
//
//        dp[1] = 1
//
//        Transition:
//
//        For every i, split it into two parts j and i - j - 1
//
//        Multiply left and right possibilities
//
//        Formula:
//
//        dp[i] += dp[j] * dp[i - j - 1]


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 3;
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        System.out.println(dp[n]);
    }
}

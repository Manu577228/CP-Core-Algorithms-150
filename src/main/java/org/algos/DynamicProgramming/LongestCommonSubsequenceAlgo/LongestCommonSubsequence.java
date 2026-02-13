package org.algos.DynamicProgramming.LongestCommonSubsequenceAlgo;

//        Longest Common Subsequence (LCS) finds the longest sequence of
//        characters that appear in the same order in two strings, but not necessarily contiguously.
//        It is a classic Dynamic Programming problem because overlapping subproblems repeat.

//       Algorithm Explanation
//
//        Use a 2D DP table where dp[i][j] = LCS length of first i chars of s1 and first j chars of s2
//
//        If characters match → take diagonal + 1
//
//        Else → take max from top or left
//
//        Final answer is at dp[n][m]

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s1 = "abcde";
        String s2 = "ace";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        out.println(dp[n][m]);
        out.flush();

    }
}
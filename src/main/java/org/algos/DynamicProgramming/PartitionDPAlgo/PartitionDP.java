package org.algos.DynamicProgramming.PartitionDPAlgo;

//          Partition DP is used when a problem can be solved by splitting a range
//         [i…j] into multiple partitions and combining optimal solutions of those subranges.
//          The DP state represents the optimal answer for a segment, and
//          transitions try all possible cut positions.
//
//      Algorithm Explanation
//
//      We define dp[i] = minimum cuts needed for substring [0…i]
//
//      For every index i, try all previous cut positions j
//
//      If substring [j+1…i] is a palindrome, update
//      dp[i] = min(dp[i], dp[j] + 1)
//
//      Final answer = dp[n-1]

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s = "aab";
        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) pal[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || pal[i + 1][j - 1]) {
                        pal[i][j] = true;
                    }
                }
            }
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (pal[0][i]) {
                dp[i] = 0;
                continue;
            }

            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                if (pal[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        out.println(dp[n - 1]);
        out.flush();
    }
}

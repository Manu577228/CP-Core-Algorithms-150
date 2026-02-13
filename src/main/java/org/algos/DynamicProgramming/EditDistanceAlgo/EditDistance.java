package org.algos.DynamicProgramming.EditDistanceAlgo;

//Edit Distance is a dynamic programming algorithm that computes the minimum number of
// operations (insert, delete, replace) required to convert one string into another.
//Each operation has a cost of 1, and the goal is to minimize total cost.


//          Algorithm Explanation
//
//          Use a DP table dp[i][j] where
//dp[i][j] = minimum operations to convert first i characters of s1 into first j characters of s2
//
//If characters match → no operation
//
//If they don’t → choose min(insert, delete, replace) + 1
//
//Final answer is stored at dp[n][m]

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s1 = "horse";
        String s2 = "ros";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                    dp[i][j - 1],
                                    dp[i - 1][j - 1]
                            )
                    );
                }
            }
        }

        out.println(dp[n][m]);
        out.flush();
    }
}
package org.algos.DynamicProgramming.DPOnGridsAlgo;

//DP in Grids is a dynamic programming technique where each
// cell’s answer depends on previously solved neighboring cells (top, left, or diagonal).
//It is used to count paths, find minimum/maximum cost paths, or check reachability in a 2D grid.
//
// Algorithm Explanation
//
//Treat each grid cell as a DP state
//
//Define what dp[i][j] represents
//
//Build the solution row by row or column by column using transitions
//
//Final answer lies in the destination cell

// Count number of unique paths from top-left (0,0) to bottom-right (n-1,m-1)
// Allowed moves: Right or Down

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = 3;
        int m = 3;

        int[][] dp = new int[n][n];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;

                int up = 0;
                int left = 0;

                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        out.println(dp[n - 1][m - 1]);
        out.flush();
    }
}

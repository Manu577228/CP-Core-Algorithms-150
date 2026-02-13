package org.algos.Arrays.PrefixSum2DAlgo;

//2D Prefix Sum is a preprocessing technique where each cell
//stores the sum of all elements from (0,0) to (i,j).
//It allows answering submatrix sum queries in O(1) time after preprocessing.

//Algorithm Explanation
//
//Start with a 2D matrix a of size n x m.
//
//Create another matrix ps of the same size.
//
//Each ps[i][j] stores the sum of all elements in the rectangle from top-left (0,0) to (i,j).
//
//To compute ps[i][j]:
//
//Take sum from top → ps[i-1][j]
//
//Take sum from left → ps[i][j-1]
//
//Subtract overlap → ps[i-1][j-1]
//
//Add current cell → a[i][j]
//
//Once built, any submatrix sum can be computed using 4 prefix values.

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int n = a.length;
        int m = a[0].length;

        int[][] ps = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = (i > 0) ? ps[i - 1][j] : 0;
                int left = (j > 0) ? ps[i][j - 1] : 0;
                int diag = (i > 0 && j > 0) ? ps[i - 1][j - 1] : 0;

                ps[i][j] = up + left - diag + a[i][j];
            }
        }

        int r1 = 0, c1 = 0, r2 = 1, c2 = 1;

        int total = ps[r2][c2];
        int subUp = (r1 > 0) ? ps[r1 - 1][c2] : 0;
        int subLeft = (c1 > 0) ? ps[r2][c1 - 1] : 0;
        int addBack = (r1 > 0 && c1 > 0) ? ps[r1 - 1][c1 - 1] : 0;

        int ans = total - subUp - subLeft + addBack;

        System.out.println(ans);
    }
}
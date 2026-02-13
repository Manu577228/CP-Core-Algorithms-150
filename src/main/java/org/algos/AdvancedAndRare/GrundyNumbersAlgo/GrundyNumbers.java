package org.algos.AdvancedAndRare.GrundyNumbersAlgo;

//        The Grundy Number Algorithm (based on Sprague–Grundy Theorem)
//        assigns a non-negative integer (Grundy value) to every position of
//        an impartial game.
//        Each position’s Grundy number equals the mex (minimum excluded value)
//        of all reachable positions.
//        If the Grundy number is 0 → losing position, otherwise winning position.
//
//        Algorithm Explanation
//
//        For every game state:
//
//        If no moves possible → Grundy = 0
//
//        Recursively compute Grundy of all reachable states
//
//        Collect those values
//
//        Compute mex of collected values
//
//        That mex is the Grundy number of current state
//
//        For multiple piles → XOR all Grundy values.

import java.io.*;
import java.util.*;

class Main {

    static int[] dp;

    static int mex(HashSet<Integer> set) {
        int mex = 0;
        while (set.contains(mex))
            mex++;
        return mex;
    }

    static int grundy(int n) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        HashSet<Integer> set = new HashSet<>();

        if (n >= 1)
            set.add(grundy(n - 1));

        if (n >= 2)
            set.add(grundy(n - 2));

        return dp[n] = mex(set);
    }

    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(System.out);

        int n = 4;

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = grundy(n);

        out.println("Grundy Number = " + result);

        if (result == 0)
            out.println("Losing Position");
        else
            out.println("Winning Position");

        out.flush();
    }
}

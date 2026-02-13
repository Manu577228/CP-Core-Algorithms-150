package org.algos.AdvancedAndRare.SpragueGrundyTheoremAlgo;

//       The Sprague–Grundy Theorem states that every impartial game under
//       normal play is equivalent to a Nim heap.
//        Each position is assigned a Grundy number (mex of reachable states).
//        If XOR of all Grundy numbers ≠ 0 → First player wins, else loses.


//        Algorithm Explanation
//
//        For every state x, compute Grundy number:
//
//        G(x) = mex({G(next_states)})
//
//        Base case: Terminal state → Grundy = 0
//
//        For multiple piles → XOR all Grundy numbers
//
//        If XOR ≠ 0 → Winning position

import java.util.*;

class Main {

    static int[] dp;

    static int grundy(int n) {
        if (n == 0) return 0;

        if (dp[n] != -1)
            return dp[n];

        HashSet<Integer> set = new HashSet<>();

        if (n >= 1)
            set.add(grundy(n - 1));

        if (n >= 2)
            set.add(grundy(n - 2));

        if (n >= 3)
            set.add(grundy(n - 3));

        int mex = 0;

        while (set.contains(mex))
            mex++;

        return dp[n] = mex;
    }

    public static void main(String[] args) {
        int n = 4;

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        int g = grundy(n);

        System.out.println("grundy Value: " + g);

        if (g != 0)
            System.out.println("First player Wins!");
        else
            System.out.println("Second Player Wins!");
    }
}

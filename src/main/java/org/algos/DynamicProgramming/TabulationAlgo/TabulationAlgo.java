package org.algos.DynamicProgramming.TabulationAlgo;

//Tabulation is a bottom-up Dynamic Programming technique where we iteratively build solutions from smaller
// subproblems and store them in a table.
//Each state is computed once, eliminating recursion and repeated work.
//
//Algorithm Explanation
//
//Identify the DP state that represents a subproblem
//
//Initialize base cases in a table
//
//Fill the table iteratively using previously computed values
//
//Final answer is stored in the last cell



class Main {

    public static void main(String[] args) throws Exception {

        int n = 5;

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
package org.algos.RecursionORBacktracking.RecursionAlgo;

//Recursion is a technique where a function calls itself to
//        solve smaller instances of the same problem.
//        It stops when a base condition is met.

//              Generic Explanation :
//
//        A problem is broken into smaller sub-problems
//
//        Each function call handles one level of work
//
//        The function calls itself with reduced input
//
//        Execution stops at the base case
//
//        Results are returned backward through the call stack

import java.io.*;

class Main {

    public static int fact(int n){
        if(n == 0) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = 4;
        int ans = fact(n);
        out.println(ans);

        out.flush();
    }
}

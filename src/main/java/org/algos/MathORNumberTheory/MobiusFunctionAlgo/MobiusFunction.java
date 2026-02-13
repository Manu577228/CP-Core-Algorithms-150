package org.algos.MathORNumberTheory.MobiusFunctionAlgo;

//The Möbius function μ(n) returns:
//
//        1 if n is square-free with even prime factors, -1
//        if square-free with odd prime factors, 0 if n has a squared prime factor

//           Algorithm Explanation :
//
//        We compute μ values for all numbers 1…N using a modified Sieve.
//
//        Initialize all μ values as 1.
//
//        For every prime p:
//
//        Multiply μ of all multiples of p by -1.
//
//        Set μ of all multiples of p² to 0 (not square-free).
//
//        Result: μ array filled in one pass similar to Sieve of Eratosthenes.

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = 10;

        int[] mu = new int[n + 1];
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            mu[i] = 1;
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= n; j += i) {
                    mu[j] *= -1;
                    isPrime[j] = false;
                }

                long sq = (long) i * i;

                if (sq <= n) {
                    for (int j = (int) sq; j <= n; j += sq) {
                        mu[j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            out.println("mu(" + i + ") = " + mu[i]);
        }

        out.flush();
    }
}

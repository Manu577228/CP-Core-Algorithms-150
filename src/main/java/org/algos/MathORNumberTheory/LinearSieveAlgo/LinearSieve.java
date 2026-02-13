package org.algos.MathORNumberTheory.LinearSieveAlgo;

//Linear Sieve is an algorithm to find all prime numbers up to
//        N in O(N) time by ensuring every composite number is marked exactly once.

//            How the Algorithm Works
//
//        Maintain a boolean array to mark prime/composite numbers
//
//        Maintain an array to store discovered prime numbers
//
//        Iterate numbers from 2 to N
//
//        If a number is not marked, it is prime → store it
//
//        For every prime discovered so far:
//
//        Mark currentNumber * prime as composite
//
//        Stop when:
//
//        product exceeds N, or
//
//        prime divides currentNumber (key to linear time)

import java.io.*;
import java.util.*;

class LinearSieveExample {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int N = 20;
        boolean[] isComposite = new boolean[N + 1];

        int[] primes = new int[N + 1];
        int primeCount = 0;

        for (int i = 2; i <= N; i++) {
            if (!isComposite[i]) {
                primes[primeCount++] = i;
            }

            for (int j = 0; j < primeCount; j++) {
                int p = primes[j];
                if (i * p > N) break;
                isComposite[i * p] = true;
                if (i % p == 0) break;
            }
        }

        out.print("Primes till " + N + ": ");
        for (int i = 0; i < primeCount; i++) {
            out.print(primes[i] + " ");
        }

        out.println();
        out.flush();
    }
}

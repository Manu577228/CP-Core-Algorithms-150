package org.algos.MathORNumberTheory.SieveOfEratosthenesAlgo;

//The Sieve of Eratosthenes is an efficient algorithm to find all prime
//        numbers up to a given number N by iteratively marking multiples of primes as
//        non-prime

//                 Algorithm Explanation
//
//        Create a boolean array isPrime[0..N] and assume all numbers are prime initially.
//
//        Mark 0 and 1 as non-prime.
//
//        Start from the first prime number 2.
//
//        For each number i from 2 to √N:
//
//        If i is still marked prime:
//
//        Mark all multiples of i starting from i*i as non-prime.
//
//        After completion, all indices marked true are prime numbers.

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 10;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

package org.algos.MathORNumberTheory.PrimeFactorizationAlgo;

//Prime Factorization is the process of expressing a number as a product
//        of its prime numbers only.
//        Every integer greater than 1 has a unique prime factorization.

//            Algorithm Explanation
//
//        Start dividing the number n from the smallest prime (2)
//
//        If a divisor divides n, keep dividing until it no longer does
//
//        Move to the next possible divisor
//
//        Stop when divisor² > n
//
//        If n > 1 at the end, it itself is a prime factor


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 12;

        PrintWriter out = new PrintWriter(System.out);

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                out.print(i + " ");
                n = n / i;
            }
        }

        if (n > 1) {
            out.print(n);
        }

        out.flush();
    }
}
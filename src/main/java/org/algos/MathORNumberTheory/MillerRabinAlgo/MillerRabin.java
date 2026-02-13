package org.algos.MathORNumberTheory.MillerRabinAlgo;

//       Miller–Rabin is a probabilistic primality test that
//        determines whether a number is prime or composite
//        using modular exponentiation and repeated squaring.
//        It is fast and reliable for very large numbers.

//          Algorithm Explanation :
//
//        Any odd number n > 2 can be written as
//        n − 1 = d × 2^r where d is odd
//
//        Pick a random base a such that 2 ≤ a ≤ n−2
//
//        Compute x = a^d % n
//
//        If x == 1 or x == n−1, pass this round
//
//        Otherwise, square x repeatedly r−1 times:
//
//        If x becomes n−1, pass
//
//        If none of the above happens → composite
//
//        Repeat for k iterations to reduce error probability

import java.io.*;
import java.util.*;

class MillerRabin {

    static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }

    static boolean isPrime(long n, int k) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        long d = n - 1;
        while ((d & 1) == 0)
            d >>= 1;

        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            long a = 2 + rand.nextInt((int) (n - 4));
            long x = modPow(a, d, n);

            if (x == 1 || x == n - 1)
                continue;

            boolean composite = true;

            long temp = d;
            while (temp != n - 1) {
                x = (x * x) % n;
                temp <<= 1;

                if (x == n - 1) {
                    composite = false;
                    break;
                }
            }

            if (composite) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long n = 13;
        int k = 5;

        System.out.println(isPrime(n, k) ? "Prime" : "Composite");
    }
}
package org.algos.MathORNumberTheory.nCrWithModuloAlgo;

//nCr represents the number of ways to choose r elements from n elements without order.
//        Formula: nCr = n! / (r! * (n−r)!), computed under modulo M.

//           Algorithm Explanation
//
//        Direct division is not possible under modulo.
//
//        If M is prime, we use Modular Multiplicative Inverse.
//
//        Precompute factorials fact[i] = i! % M.
//
//        Use Fermat’s Little Theorem
//        a⁻¹ mod M = a^(M−2) mod M
//
//        Final formula becomes:
//        nCr % M = fact[n] * inv(fact[r]) * inv(fact[n−r]) % M

import java.io.*;
import java.util.*;

class Main {

    static final long MOD = 1000000007L;

    static long power(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;

            b >>= 1;
        }

        return res;
    }

    static long nCr(int n, int r) {
        if (r > n) return 0;

        long[] fact = new long[n + 1];

        fact[0] = 1;

        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % MOD;

        long invR = power(fact[r], MOD - 2);
        long invNR = power(fact[n - r], MOD - 2);

        return (((fact[n] * invR) % MOD) * invNR) % MOD;
    }


    public static void main(String[] args) {
        int n = 5, r = 2;

        System.out.println(nCr(n, r));
    }
}





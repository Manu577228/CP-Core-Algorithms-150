package org.algos.MathORNumberTheory.ModularInverseFermatAlgo;

//The modular inverse of a under modulo m is a number x such that
//        (a × x) % m = 1, when m is prime and gcd(a, m) = 1.

//           Algorithm Explanation
//
//        Fermat’s Little Theorem says:
//        a^(m−1) % m = 1 (when m is prime and a % m ≠ 0)
//
//        Rearranging gives:
//        a^(m−2) % m = a^(-1) % m
//
//        So, modular inverse = fast power of a to (m−2) under modulo m
//
//        Fast power is computed using Binary Exponentiation to stay efficient

import java.io.*;
import java.util.*;

class Main {

    static long power(long base, long exp, long mod) {
        long result = 1;

        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    static long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public static void main(String[] args) throws Exception {
        long a = 3;
        long mod = 11;

        long inverse = modInverse(a, mod);

        System.out.println(inverse);
    }
}


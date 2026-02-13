package org.algos.MathORNumberTheory.ChineseRemainderTheoremAlgo;

//Chinese Remainder Theorem states that if moduli are pairwise
//        coprime, then a system of congruences has a unique solution modulo
//        the product of moduli.

//          Algorithm Explanation :
//
//        You are given equations of the form
//        x ≡ ai (mod mi)
//
//        All mi must be pairwise coprime
//
//        Compute total modulus M = m1 * m2 * ... * mk
//
//        For each equation:
//
//        Compute Mi = M / mi
//
//        Compute modular inverse yi = Mi⁻¹ mod mi
//
//        Add contribution ai * Mi * yi
//
//        Final answer is (sum % M + M) % M

import java.io.*;
import java.util.*;

class Main {

    static long modInverse(long a, long m) {
        long m0 = m;
        long x0 = 0, x1 = 1;

        while (a > 1) {
            long q = a / m;
            long t = m;

            m = a % m;
            a = t;

            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0) x1 += m0;
        return x1;
    }

    public static void main(String[] args) throws Exception {
        long[] rem = {2, 3};
        long[] mod = {3, 5};

        int n = rem.length;

        long M = 1;
        for (int i = 0; i < n; i++) {
            M *= mod[i];
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long Mi = M / mod[i];

            long inv = modInverse(Mi, mod[i]);

            ans += rem[i] * Mi * inv;
        }

        ans = (ans % M + M) % M;

        System.out.println(ans);
    }
}
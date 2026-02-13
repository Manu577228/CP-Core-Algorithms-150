package org.algos.MathORNumberTheory.LucasTheoremAlgo;

//        Lucas Theorem helps compute nCr mod p where p is prime, by breaking
//        n and r into base-p digits.
//        The result is the product of smaller combinations of
//        corresponding digits mod p.

//          Algorithm Explanation :
//
//        Works only when p is prime
//
//        Convert n and r into base-p representation
//
//        For each digit position:
//
//        Take digits ni from n and ri from r
//
//        If ri > ni → result = 0
//
//        Else multiply C(ni, ri) mod p
//
//        Final answer is the product of all digit-wise combinations mod p

//Example used: n = 5, r = 2, p = 3
//        Expected result: 5C2 = 10, 10 mod 3 = 1

import java.io.*;
import java.util.*;

class Main {

    static long nCrModP(long n, long r, int p) {
        if (r > n) return 0;

        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }

        return res % p;
    }

    static long lucas(long n, long r, int p) {
        long ans = 1;

        while (n > 0 && r > 0) {
            long ni = n % p;
            long ri = r % p;

            if (ri > ni) return 0;

            ans = (ans * nCrModP(ni, ri, p)) % p;

            n /= p;
            r /= p;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long n = 5;
        long r = 2;
        int p = 3;

        out.println(lucas(n, r, p));
        out.flush();
    }
}

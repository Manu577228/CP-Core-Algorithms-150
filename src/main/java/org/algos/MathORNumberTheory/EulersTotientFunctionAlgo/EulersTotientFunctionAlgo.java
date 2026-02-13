package org.algos.MathORNumberTheory.EulersTotientFunctionAlgo;

//Euler’s Totient Function φ(n) gives the count of
//        positive integers ≤ n that are coprime with n.
//        Two numbers are coprime if their GCD = 1.

//           Algorithm Explanation
//
//        Start with result = n
//
//        Iterate through all possible prime factors p of n
//
//        If p divides n:
//
//        Remove all occurrences of p from n
//
//        Subtract result / p from result
//
//        After loop, if n > 1, it is a prime factor:
//
//        Subtract result / n
//
//        Final result is φ(original n)

import java.io.*;
import java.util.*;

class Main {

    public static int phi(int n) {
        int result = n;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }

                result -= result / p;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        int n = 10;
        System.out.println(phi(n));
    }
}

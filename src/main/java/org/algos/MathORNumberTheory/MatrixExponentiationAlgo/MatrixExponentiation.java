package org.algos.MathORNumberTheory.MatrixExponentiationAlgo;

//Matrix Exponentiation is a technique to compute the
//        power of a matrix efficiently in O(log N) time.
//        It is mainly used to solve linear recurrence relations like Fibonacci.

//                 Algorithm Explanation
//
//        Any linear recurrence can be represented using a transition matrix.
//
//        Instead of multiplying the matrix N times, we use binary exponentiation.
//
//        If power is even → square the matrix.
//
//        If power is odd → multiply once and reduce power.
//
//        This reduces time from O(N) to O(log N).
//
//        Final matrix multiplied with base vector gives the answer.

//Example: Fibonacci Number using Matrix Exponentiation
//
//        We compute F(n) using matrix power.
//
//        Fibonacci Relation
//        F(n) = F(n−1) + F(n−2)

//    Transition Matrix
//
//        |1 1|
//        |1 0|

import java.io.*;
import java.util.*;

class Main {

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] r = new long[2][2];

        r[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        r[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        r[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        r[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];

        return r;
    }

    static long[][] power(long[][] m, int n) {
        if (n == 1) return m;

        long[][] half = power(m, n / 2);
        long[][] res = multiply(half, half);

        if (n % 2 == 1)
            res = multiply(res, m);

        return res;
    }

    static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] base = {
                {1, 1},
                {1, 0}
        };

        long[][] ans = power(base, n - 1);
        return ans[0][0];
    }

    public static void main(String[] args) throws Exception {
        int n = 6;
        System.out.println(fibonacci(n));
    }
}


package org.algos.MathORNumberTheory.ModularInverseExtendedGCD;

//The modular inverse of a modulo m is a number x such that
//        (a × x) % m = 1, and it exists only if gcd(a, m) = 1.

//         Algorithm Explanation (Extended GCD)
//
//        Extended GCD finds integers x and y such that
//        a·x + m·y = gcd(a, m)
//
//        If gcd(a, m) ≠ 1, inverse does not exist
//
//        If gcd(a, m) = 1, then
//        a·x + m·y = 1
//
//        Taking modulo m on both sides:
//
//        a·x ≡ 1 (mod m)
//
//        Hence, x is the modular inverse
//
//        If x is negative, convert it to positive using
//        (x % m + m) % m


import java.io.*;

class Main {

    static long extendedGCD(long a, long b, long[] x, long[] y) {
        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        }

        long[] x1 = new long[1];
        long[] y1 = new long[1];

        long gcd = extendedGCD(b, a % b, x1, y1);

        x[0] = y1[0];
        y[0] = x1[0] - (a / b) * y1[0];

        return gcd;
    }

    public static void main(String[] args) {
        long a = 3;
        long m = 11;

        long[] x = new long[1];
        long[] y = new long[1];

        long g = extendedGCD(a, m, x, y);

        if (g != 1) {
            System.out.println("Modular Inverse does not exist");
        } else {
            long inverse = (x[0] % m + m) % m;

            System.out.println("Modular inverse of " + a + " modulo " + m + " is " + inverse);
        }
    }
}

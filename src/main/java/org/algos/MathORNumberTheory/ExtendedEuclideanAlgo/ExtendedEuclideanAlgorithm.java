package org.algos.MathORNumberTheory.ExtendedEuclideanAlgo;

//The Extended Euclidean Algorithm finds integers x and y such that
//        a·x + b·y = gcd(a, b), along with the gcd of a and b.

//         How the Algorithm Works
//
//        Uses the same idea as Euclidean Algorithm (remainder reduction).
//
//        Recursively breaks gcd(a, b) into gcd(b, a % b).
//
//        While returning back, it builds coefficients x and y.
//
//        Final result satisfies: a*x + b*y = gcd(a, b).


import java.io.*;
import java.util.*;

class Main {

    static long coeffX;
    static long coeffY;

    static long solve(long a, long b) {
        if (b == 0) {
            coeffX = 1;
            coeffY = 0;
            return a;
        }

        long gcd = solve(b, a % b);
        long prevX = coeffX;
        coeffX = coeffY;
        coeffY = prevX - (a / b) * coeffY;
        return gcd;
    }

    public static void main(String[] args) throws Exception {
        long a = 30;
        long b = 20;

        long gcd = solve(a, b);

        System.out.println("GCD = " + gcd);
        System.out.println("x = " + coeffX);
        System.out.println("y = " + coeffY);
        System.out.println("Verification = " + (a * coeffX + b * coeffY));
    }
}
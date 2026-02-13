package org.algos.MathORNumberTheory.EuclideanAlgo;

//GCD of two integers is the largest positive number that divides both numbers.
//
//        Euclidean Algorithm computes GCD using repeated remainders.

//        How the Algorithm Works :
//
//        Take two numbers a and b
//
//        While b ≠ 0
//
//        Compute remainder r = a % b
//
//        Replace a = b
//
//        Replace b = r
//
//        When b = 0, a is the GCD

import java.io.*;

class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;

        int ans = gcd(a, b);

        System.out.println(ans);
    }
}
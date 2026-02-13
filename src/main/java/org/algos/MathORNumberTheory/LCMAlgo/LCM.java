package org.algos.MathORNumberTheory.LCMAlgo;

//LCM (Least Common Multiple) of two numbers is the smallest positive number
//        that is divisible by both numbers.
//        It is calculated using the relation: LCM(a, b) = (a × b) / GCD(a, b).

//            Algorithm Explanation
//
//        To compute LCM efficiently, we first compute GCD using Euclid’s Algorithm
//
//        Euclid’s Algorithm works by repeatedly replacing:
//
//        (a, b) → (b, a % b)
//
//        When b becomes 0, a becomes the GCD
//
//        Once GCD is known:
//
//        Multiply the two numbers
//
//        Divide the product by GCD
//
//        This avoids checking multiples manually (which is slow)

import java.io.*;
import java.util.*;

class Main {

    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) throws Exception {
        long a = 6;
        long b = 8;

        long ans = lcm(a, b);

        System.out.println(ans);
    }
}

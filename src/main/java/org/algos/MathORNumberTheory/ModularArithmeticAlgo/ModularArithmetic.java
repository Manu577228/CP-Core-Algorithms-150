package org.algos.MathORNumberTheory.ModularArithmeticAlgo;

//Modular Exponentiation computes (ab) mod m
//        efficiently without overflow using repeated squaring.

//How the Algorithm Works :
//
//        Directly computing a ^ b
//        is slow and overflows
//
//        Break exponent b into binary form
//
//        Square the base at every step
//
//        If current bit of b is 1, multiply result with base
//
//        Apply modulo at every operation to keep numbers small

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        long a = 2;
        long b = 5;
        long m = 13;

        long res = 1;
        a = a % m;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % m;
            }

            a = (a * a) % m;
            b = b >> 1;
        }

        System.out.println(res);
    }
}
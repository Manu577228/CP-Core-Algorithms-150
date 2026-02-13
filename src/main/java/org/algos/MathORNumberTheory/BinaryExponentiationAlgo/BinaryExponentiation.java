package org.algos.MathORNumberTheory.BinaryExponentiationAlgo;


//Binary Exponentiation is an algorithm to compute a ^ b
//        efficiently by repeatedly squaring the base and reducing the exponent by half.
//        It reduces time from O(b) to O(log b).

//         Algorithm Explanation
//
//        We want to compute base^power
//
//        Instead of multiplying base repeatedly, we:
//
//        Check the last bit of power
//
//        If power is odd, multiply result with base
//
//        Square the base
//
//        Divide power by 2 (right shift)
//
//        Repeat until power becomes 0


import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        long base = 2;
        long power = 5;
        long ans = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                ans = ans * base;
            }

            base = base * base;
            power = power >> 1;
        }

        out.println(ans);
        out.flush();
    }
}
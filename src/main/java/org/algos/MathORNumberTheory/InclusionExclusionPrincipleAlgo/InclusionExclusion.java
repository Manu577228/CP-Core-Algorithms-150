package org.algos.MathORNumberTheory.InclusionExclusionPrincipleAlgo;

//     The Inclusion–Exclusion Principle is used to count elements satisfying at
//        least one condition by adding
//        individual counts and subtracting overlaps to avoid double counting.

//             Generic Algorithm Explanation :
//
//        We first include counts of numbers divisible by each condition
//
//        Then exclude counts of numbers divisible by intersections (LCM of conditions)
//
//        This alternating + / − pattern continues for all combinations
//
//        Formula for two sets A, B:
//
//        |A ∪ B| = |A| + |B| − |A ∩ B|
//
//        In number theory, intersections are computed using LCM

//Example: Count numbers ≤ N divisible by 2 or 3

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int N = 10;
        int a = 2;
        int b = 3;

        int countA = N / a;
        int countB = N / b;

        int lcmAB = (a * b) / gcd(a, b);
        int countAB = N / lcmAB;

        int result = countA + countB - countAB;

        out.println(result);
        out.flush();

    }

    static int gcd(int x, int y) {
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }

        return x;
    }
}



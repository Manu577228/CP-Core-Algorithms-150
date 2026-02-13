package org.algos.BitManipulation.GrayCodeAlgo;

//Gray Code is a binary number sequence where two
//        consecutive numbers differ by exactly one bit.
//        It is generated using the formula: Gray = n ^ (n >> 1).

//           Algorithm Explanation :
//
//        Start with normal numbers from 0 to (2ⁿ − 1)
//
//        For every number i:
//
//        Right shift i by 1 bit → (i >> 1)
//
//        XOR it with original i
//
//        XOR ensures only one bit changes between consecutive values
//
//        This guarantees valid Gray Code sequence

import java.io.*;

class GrayCode {
    public static void main(String[] args) throws Exception {
        int n = 2;
        int limit = 1 << n;

        for (int i = 0; i < limit; i++) {
            int gray = i ^ (i >> 1);

            System.out.println("Binary: " + toBinary(i, n) + " F=Gray: " + toBinary(gray, n));
        }
    }

    static String toBinary(int x, int bits) {
        String s = Integer.toBinaryString(x);

        while (s.length() < bits)
            s = "0" + s;

        return s;
    }
}


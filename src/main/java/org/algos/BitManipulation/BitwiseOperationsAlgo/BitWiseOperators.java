package org.algos.BitManipulation.BitwiseOperationsAlgo;

//        Bitwise Operators Algorithm uses binary-level operations
//        (AND, OR, XOR, SHIFT) to solve number problems efficiently
//        by directly manipulating bits.
//        It avoids arithmetic overhead and works in O(1) or O(log N) time.

//          Generic Explanation
//
//        Every number is stored in binary (0s and 1s)
//
//        Bitwise operators act bit by bit
//
//        & checks common set bits
//
//        | sets bits if any side has 1
//
//        ^ toggles bits (1 if different)
//
//        << and >> shift bits to multiply/divide by powers of 2
//
//        These operations are faster than arithmetic

//Example: Check if a Number is Even or Odd using Bitwise AND
//
//        Logic:
//
//        Last bit of even number = 0
//
//        Last bit of odd number = 1
//
//        n & 1 checks last bit

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 5;

        if ((n & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
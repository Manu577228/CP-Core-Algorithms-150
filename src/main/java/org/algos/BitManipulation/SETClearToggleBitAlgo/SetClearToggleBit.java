package org.algos.BitManipulation.SETClearToggleBitAlgo;

//   Set / Clear / Toggle are bitwise operations used to modify a specific bit of a number.
//
//        They work using bitwise OR, AND, XOR with a shifted mask.

//           How the Algorithm Works
//
//        Choose the bit position i (0-based, from right).
//
//        Create a mask using 1 << i.
//
//        Apply:
//
//        Set → force bit to 1
//
//        Clear → force bit to 0
//
//        Toggle → flip the bit (0↔1)
//
//        The rest of the bits remain unchanged.

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 5;

        int i = 1;

        int mask = 1 << i;

        int setResult = n | mask;
        int clearResult = n & ~mask;
        int toggleResult = n ^ mask;

        System.out.println("Original : " + n);
        System.out.println("Set Bit : " + setResult);
        System.out.println("Clear Bit : " + clearResult);
        System.out.println("Toggle Bit : " + toggleResult);

    }
}
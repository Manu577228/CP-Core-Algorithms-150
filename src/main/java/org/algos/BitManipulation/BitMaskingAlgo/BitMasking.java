package org.algos.BitManipulation.BitMaskingAlgo;

//Bit Masking is a technique where integers are used as binary representations
// to efficiently
//        represent, check, or manipulate multiple boolean states using bitwise operators.

//            Generic Explanation
//
//        Each bit in an integer represents a state (0 or 1)
//
//        Bit position i corresponds to element/index i
//
//        1 << i sets the i-th bit
//
//        (mask & (1 << i)) != 0 checks whether the i-th bit is ON
//
//        Looping masks from 0 to (1<<n)-1 covers all combinations

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3};
        int n = arr.length;

        int totalMasks = 1 << n;

        for (int mask = 0; mask < totalMasks; mask++) {
            System.out.print("{");

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println("}");
        }
    }
}


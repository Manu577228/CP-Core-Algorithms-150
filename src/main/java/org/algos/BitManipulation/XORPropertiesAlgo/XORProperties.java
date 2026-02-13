package org.algos.BitManipulation.XORPropertiesAlgo;

//        XOR (^) is a bitwise operator that returns 1 if bits are different, 0 if same.
//        It is widely used to find unique elements, toggle bits, and cancel duplicates.

//          XOR Algorithm :
//
//        XOR of a number with itself becomes 0
//
//        XOR of a number with 0 remains unchanged
//
//        XOR is commutative → order doesn’t matter
//
//        XOR is associative → grouping doesn’t matter
//
//        Repeating numbers cancel out, leaving the unique value
//
//        Used when all numbers appear twice except one

//Example: {2, 3, 2} → Unique number = 3

import java.io.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2};

        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        System.out.println(xor);
    }
}
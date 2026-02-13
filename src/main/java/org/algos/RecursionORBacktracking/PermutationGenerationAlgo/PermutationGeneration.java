package org.algos.RecursionORBacktracking.PermutationGenerationAlgo;

//Permutation generation is the process of producing all possible arrangements of elements
//        where order matters, using recursion to fix one position at a time.

//                Algorithm Explanation :
//
//        Fix one position in the array at a time (starting from index 0)
//
//        Try placing every remaining element at the current position
//
//        Swap the chosen element into the current position
//
//        Recurse for the next position
//
//        After recursion, undo the swap (backtracking) to restore the original state

//example: {1, 2, 3}

import java.io.*;
import java.util.*;

class Main {

    static void permute(int[] a, int idx) {
        if (idx == a.length) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for (int i = idx; i < a.length; i++) {
            int temp = a[idx];
            a[idx] = a[i];
            a[i] = temp;

            permute(a, idx + 1);

            temp = a[idx];
            a[idx] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        permute(a, 0);
    }
}

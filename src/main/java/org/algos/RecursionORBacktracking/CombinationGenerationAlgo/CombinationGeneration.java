package org.algos.RecursionORBacktracking.CombinationGenerationAlgo;

//Combination Generation is a recursive technique to generate all
//        possible selections of k elements from n elements without considering order.
//        It uses decision making (pick / not pick) at each recursive step.

//           Algorithm Explanation
//
//        We build combinations step by step
//
//        At each index, we choose the current element
//
//        Move to next index and reduce required elements (k)
//
//        When k == 0, one valid combination is formed
//
//        Backtrack to explore other choices

//Array = {1, 2, 3}
//        Choose k = 2

import java.io.*;
import java.util.*;

class Main {

    static int[] arr = {1, 2, 3};
    static int n = arr.length;
    static int k = 2;
    static int[] temp = new int[k];

    public static void main(String[] args) {
        generate(0, 0);
    }

    static void generate(int idx, int cnt) {
        if (cnt == k) {
            System.out.println(Arrays.toString(temp));
            return;
        }

        if (idx == n) return;

        temp[cnt] = arr[idx];
        generate(idx + 1, cnt + 1);
        generate(idx + 1, cnt);
    }
}
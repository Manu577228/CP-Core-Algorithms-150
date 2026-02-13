package org.algos.Arrays.MeetintheMiddleAlgo;

//Meet in the Middle splits a problem into two halves,
//solves each half independently, and then combines the results efficiently.
//It is mainly used when brute force is too slow but DP is not feasible.

//How the Algorithm Works :
//
//Split the input into two halves
//
//Generate all possible results for each half
//
//Store results of one half
//
//For each result in the other half, search/match required value
//
//Combine both halves to get the final answer

//Java Code
//Example Used
//
//Problem:
//Given array {1, 2, 3, 4} → Check if any subset has sum = 5

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 3, 4};
        int target = 5;

        int n = a.length;

        int mid = n / 2;

        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, n);

        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();

        generate(left, 0, 0, L);
        generate(right, 0, 0, R);

        Collections.sort(R);

        boolean ok = false;

        for (int x : L) {
            int need = target - x;

            if (Collections.binarySearch(R, need) >= 0) {
                ok = true;
                break;
            }
        }

        System.out.println(ok ? "YES" : "NO");
    }

    static void generate(int[] a, int i, int sum, ArrayList<Integer> res) {
        if (i == a.length) {
            res.add(sum);
            return;
        }

        generate(a, i + 1, sum, res);
        generate(a, i + 1, sum + a[i], res);
    }
}
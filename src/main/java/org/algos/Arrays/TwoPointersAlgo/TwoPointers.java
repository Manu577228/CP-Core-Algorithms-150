package org.algos.Arrays.TwoPointersAlgo;

//Two Pointers Algorithm uses two indices that move through a data structure (usually an array)
//to efficiently solve problems by reducing unnecessary iterations.

//Generic Explanation

//Initialize two pointers (usually left and right)
//
//Pointers start at different positions (start–end or both at start)
//
//Evaluate a condition using elements at pointers
//
//Based on the condition:
//
//Move left forward or
//
//Move right backward
//
//Continue until pointers meet or cross
//
//Eliminates nested loops → improves performance

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 3, 4, 6};
        int x = 6;

        int l = 0;
        int r = a.length - 1;

        boolean f = false;

        while (l < r) {
            int s = a[l] + a[r];

            if (s == x) {
                f = true;
                break;
            }

            if (s < x) {
                l++;
            } else {
                r--;
            }
        }

        if (f) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
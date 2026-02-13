package org.algos.Strings.KMPAlgo;

//KMP (Knuth–Morris–Pratt) is a string pattern-matching
//        algorithm that avoids rechecking characters by using information from previous matches.
//        It preprocesses the pattern to achieve linear time searching.

//How the Algorithm Works :
//
//        We preprocess the pattern to build an LPS array
//
//        LPS[i] = length of the longest proper prefix which is also a suffix for pattern[0…i]
//
//        While matching:
//
//        If characters match → move both pointers
//
//        If mismatch occurs → shift pattern using LPS instead of restarting
//
//        This avoids redundant comparisons and guarantees linear time

//Example
//        Text = "ababcababc"
//        Pattern = "ababc"


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String txt = "ababcababc";
        String pat = "ababc";

        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[n];

        computeLPS(pat, lps);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    static void computeLPS(String pat, int[] lps) {
        int len = 0;
        int i = 1;

        lps[0] = 0;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
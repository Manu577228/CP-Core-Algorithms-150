package org.algos.Strings.RabinKarpAlgo;

//Rabin–Karp Algorithm is a string pattern matching algorithm that
//        uses hashing to compare the pattern with substrings of text efficiently.
//        It avoids repeated character comparisons by sliding a rolling hash over the text.

//Algorithm Explanation :
//
//        Convert the pattern into a numeric hash value
//
//        Compute hash for the first window of text (same length as pattern)
//
//        Slide the window one character at a time
//
//        Update hash using rolling hash formula (remove left char, add right char)
//
//        If window hash == pattern hash → verify characters one by one
//
//        Matching verification avoids false positives due to hash collision

import java.io.*;
import java.util.*;

class RabinKarp {
    public static void main(String[] args) {
        String text = "abcd";
        String pattern = "bc";

        int n = text.length();
        int m = pattern.length();

        int base = 256;
        int mod = 101;

        int pHash = 0;
        int tHash = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++)
            h = (h * base) % mod;

        for (int i = 0; i < m; i++) {
            pHash = (base * pHash + pattern.charAt(i)) % mod;
            tHash = (base * tHash + text.charAt(i)) % mod;
        }

        for (int i = 0; i <= n; i++) {
            if (pHash == tHash) {
                int j = 0;
                while (j < m && text.charAt(i + j) == pattern.charAt(j))
                    j++;

                if (j == m)
                    System.out.println("Pattern found at index: " + i);
            }

            if (i < n - m) {
                tHash = (base * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % mod;

                if (tHash < 0)
                    tHash += mod;
            }
        }
    }
}



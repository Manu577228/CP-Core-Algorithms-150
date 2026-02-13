package org.algos.Strings.ZAlgo;

//Z-Algorithm computes an array where each index stores the length of the
//        longest substring starting from that index which matches the prefix of the string.
//        It helps in pattern matching and string analysis efficiently.

//How the Algorithm Works :
//
//        Create an array Z[] where Z[i] = length of match between s[0…] and s[i…]
//
//        Maintain a window [L, R] where substring matches the prefix
//
//        If i > R → start matching from scratch
//
//        If i ≤ R → reuse previously computed Z values
//
//        Extend matches only when necessary
//
//        This avoids repeated comparisons

import java.io.*;

class ZAlgorithm {
    public static void main(String[] args) {
        String s = "aaabxaab";
        int n = s.length();

        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r) == s.charAt(r - l)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;

                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r) == s.charAt(r - l)) {
                        r++;
                    }

                    z[i] = r - l;
                    r--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(z[i] + " ");
        }
    }
}
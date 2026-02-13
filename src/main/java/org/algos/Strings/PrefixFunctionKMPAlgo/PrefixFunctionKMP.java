package org.algos.Strings.PrefixFunctionKMPAlgo;

//Prefix Function (π array) stores, for each index i, the length of the
//        longest proper prefix of the string that is also a suffix ending at i.
//        It helps avoid rechecking characters during pattern matching.

//              Algorithm Explanation :
//
//        We build an array pi[] where pi[i] = length of longest prefix matching
//        suffix ending at i
//
//        Start from index 1 because prefix at index 0 is always 0
//
//        Maintain a pointer j → length of previous longest prefix
//
//        If characters match → extend prefix (j++)
//
//        If mismatch → jump back using pi[j-1] (no rechecking)
//
//        Store j in pi[i]
//
//        This jumping is what makes KMP linear time

//Example string: "ababaca"

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        String s = "ababaca";
        int n = s.length();

        int[] pi = new int[n];
        pi[0] = 0;

        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            pi[i] = j;
        }

        for (int x : pi) {
            System.out.print(x + " ");
        }
    }
}
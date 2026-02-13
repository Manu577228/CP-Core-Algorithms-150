package org.algos.Strings.KasaiAlgo;

//Kasai’s Algorithm constructs the LCP (Longest Common Prefix) array
//        from a given suffix array in linear time.
//        It efficiently computes LCP values by reusing previously matched characters.

//Algorithm Explanation :
//
//        You are given a string and its suffix array
//
//        Create an array rank[] where rank[i] = position of suffix i in suffix array
//
//        Traverse the string index by index
//
//        For each index i, compare suffix starting at i with the next suffix in suffix array
//
//        Count matching characters using a variable k
//
//        Store k as LCP value
//
//        Reduce k by 1 for the next iteration (important optimization)
//
//        This reuse makes the algorithm O(n)


import java.io.*;
import java.util.*;

class Main {

    static int[] buildLCP(String s, int[] sa) {
        int n = s.length();
        int[] lcp = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++)
            rank[sa[i]] = i;

        int k = 0;

        for (int i = 0; i < n; i++) {
            if (rank[i] == n - 1) {
                k = 0;
                continue;
            }

            int j = sa[rank[i] + 1];

            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k))
                k++;

            lcp[rank[i]] = k;

            if (k > 0) k--;
        }

        return lcp;
    }

    public static void main(String[] args) {
        String s = "banana";

        int[] sa = {5, 3, 1, 0, 4, 2};

        int[] lcp = buildLCP(s, sa);

        for (int x : lcp)
            System.out.print(x + " ");
    }
}

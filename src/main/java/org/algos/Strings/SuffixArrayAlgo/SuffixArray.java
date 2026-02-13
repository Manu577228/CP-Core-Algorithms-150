package org.algos.Strings.SuffixArrayAlgo;


//A Suffix Array is an array of indices representing all suffixes of a
//        string sorted in lexicographical order.
//        It enables fast string operations like pattern matching and
//        longest common prefix queries.

//              Algorithm Explanation :
//
//        Generate all suffixes of the string.
//
//        Store each suffix along with its starting index.
//
//        Sort suffixes lexicographically.
//
//        Extract only the starting indices → this is the Suffix Array.
//
//        Optimized versions avoid storing full strings and use ranking (doubling technique).

import java.io.*;
import java.util.*;

class Main {

    static class Suffix {
        int index;
        int rank;
        int nextRank;
    }

    public static void main(String[] args) throws Exception {
        String s = "banana";
        int n = s.length();

        Suffix[] suf = new Suffix[n];

        for (int i = 0; i < n; i++) {
            suf[i] = new Suffix();
            suf[i].index = i;
            suf[i].rank = s.charAt(i) - 'a';
            suf[i].nextRank = (i + 1 < n) ? s.charAt(i + 1) - 'a' : -1;
        }

        Arrays.sort(suf, (a, b) -> {
            if (a.rank != b.rank) return a.rank - b.rank;
            return a.nextRank - b.nextRank;
        });

        int[] ind = new int[n];

        for (int k = 4; k < 2 * n; k *= 2) {
            int rank = 0;
            int prevRank = suf[0].rank;
            suf[0].rank = rank;
            ind[suf[0].index] = 0;

            for (int i = 1; i < n; i++) {
                if (suf[i].rank == prevRank && suf[i].nextRank == suf[i - 1].nextRank) {
                    suf[i].rank = rank;
                } else {
                    prevRank = suf[i].rank;
                    suf[i].rank = ++rank;
                }

                ind[suf[i].index] = i;
            }

            for (int i = 0; i < n; i++) {
                int nextIndex = suf[i].index + k / 2;
                suf[i].nextRank = (nextIndex < n) ? suf[ind[nextIndex]].rank : -1;
            }

            Arrays.sort(suf, (a, b) -> {
                if (a.rank != b.rank) return a.rank - b.rank;
                return a.nextRank - b.nextRank;
            });
        }

        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = suf[i].index;
        }

        System.out.println("Suffix Array:");
        for (int x : suffixArray) {
            System.out.print(x + " ");
        }
    }
}
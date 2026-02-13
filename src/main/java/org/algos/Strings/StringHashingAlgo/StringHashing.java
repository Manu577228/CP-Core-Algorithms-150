package org.algos.Strings.StringHashingAlgo;

//String Hashing converts a string into a numeric value using a mathematical
//        formula so that string comparisons can be done efficiently.
//        It is mainly used to compare substrings in O(1) time after preprocessing.

//Algorithm Explanation
//
//        Each character is mapped to a number ('a' → 1, 'b' → 2, …).
//
//        A base p (usually a prime like 31) is chosen.
//
//        The hash of a string is computed as:
//        s[0]*p^0 + s[1]*p^1 + s[2]*p^2 + ...
//
//        Prefix hashes are stored so substring hashes can be computed quickly.
//
//        Two substrings are equal if their hashes are equal (with very high probability).

//(Simple example: compute hash of string "abc")

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String s = "abc";
        int n = s.length();

        long p = 31;
        long mod = 1000000007;

        long hash = 0;
        long power = 1;

        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash + val * power) % mod;
            power = (power * p) % mod;
        }

        out.println("Hash of String \"" + s + "\" = " + hash);
        out.flush();
    }
}
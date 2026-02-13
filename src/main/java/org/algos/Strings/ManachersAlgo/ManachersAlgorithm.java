package org.algos.Strings.ManachersAlgo;

//Manacher’s Algorithm finds the longest palindromic
//        substring in a string in linear time O(n).
//        It avoids rechecking characters by using symmetry around palindrome centers.

//Algorithm Explanation
//
//        Convert the string to a new format by inserting separators (#)
//        to handle even & odd palindromes uniformly
//
//        Maintain an array p[] where p[i] = radius of palindrome centered at i
//
//        Track the current center (c) and right boundary (r) of the farthest palindrome
//
//        For every position i:
//
//        Use mirror property: mirror = 2*c - i
//
//        Initialize p[i] using previously known palindrome info
//
//        Expand around i while characters match
//
//        Update c and r if palindrome expands beyond current boundary
//
//        The maximum value in p[] gives the longest palindrome


import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        String s = "aba";
        String t = transform(s);

        int n = t.length();

        int[] p = new int[n];

        int c = 0, r = 0;

        for (int i = 1; i < n - 1; i++) {
            int mir = 2 * c - i;

            if (i < r) p[i] = Math.min(r - i, p[mir]);

            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }

        int len = 0, center = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > len) {
                len = p[i];
                center = i;
            }
        }

        int start = (center - len) / 2;
        String ans = s.substring(start, start + len);

        System.out.println(ans);

    }

    static String transform(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }

        sb.append("#$");
        return sb.toString();
    }
}

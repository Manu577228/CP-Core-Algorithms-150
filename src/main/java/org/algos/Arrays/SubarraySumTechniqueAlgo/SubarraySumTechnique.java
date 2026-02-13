package org.algos.Arrays.SubarraySumTechniqueAlgo;

//The Subarray Sum Technique finds whether a contiguous subarray
//sums to a given value using prefix sums.
//It avoids nested loops by tracking previously seen sums.

//Algorithm Explanation:
//
//        Maintain a running sum pref
//
//        If at any index pref==target,subarray starts from index 0
//
//        If(pref-target)already appeared before,a subarray exists
//
//        Store all prefix sums in a HashSet
//
//        Traverse array once → answer found efficiently

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] a = {1, 2, 3, 4};
        int k = 6;
        HashSet<Integer> s = new HashSet<>();

        int pref = 0;

        boolean ok = false;

        for (int i = 0; i < a.length; i++) {
            pref += a[i];

            if (pref == k) {
                ok = true;
                break;
            }

            if (s.contains(pref - k)) {
                ok = true;
                break;
            }

            s.add(pref);
        }

        out.println(ok ? "SubArray Exists" : "No SubArray");
        out.flush();
    }
}
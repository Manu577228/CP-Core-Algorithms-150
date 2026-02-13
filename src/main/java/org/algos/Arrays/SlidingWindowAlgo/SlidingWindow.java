package org.algos.Arrays.SlidingWindowAlgo;

//Sliding Window is an optimization technique to process a contiguous
//        subarray/substring by maintaining a moving window.
//It avoids recomputation by adding the next element and removing the previous one.

// Generic Explanation
//
//Choose a window size (fixed or dynamic).
//
//Place the window at the start of the array.
//
//Compute the result for the first window.
//
//Slide the window one step to the right:
//
//Add the new incoming element.
//
//Remove the outgoing element.
//
//Update the answer at each step.
//
//Continue until the window reaches the end.

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] a = {2, 1, 5, 1, 3, 2};

        int k = 3;

        int w = 0;

        for (int i = 0; i < k; i++) {
            w += a[i];
        }

        int ans = w;

        for (int i = k; i < a.length; i++) {
            w += a[i];
            w -= a[i - k];

            if (w > ans) ans = w;
        }

        out.println(ans);
        out.flush();
    }
}


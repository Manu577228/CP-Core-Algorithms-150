package org.algos.Stacks.LargestRectangleinHistogram;

//The Largest Rectangle in a Histogram problem finds the
//maximum area rectangle that can be formed using contiguous bars of a histogram.
//Each bar has a fixed width of 1 and varying heights.

//Algorithm Explanation :
//
//We use a monotonic increasing stack to store indices of bars.
//
//The stack always keeps indices whose heights are in increasing order.
//
//When a smaller height bar appears:
//
//We pop bars from the stack.
//
//Each popped bar becomes the smallest bar of a rectangle.
//
//For each popped bar:
//
//Width is calculated using current index and new stack top.
//
//Area = height × width
//
//After traversing all bars:
//
//We pop remaining bars and calculate area similarly.
//
//Track the maximum area during the process.

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] h = {2, 1, 5, 6, 2, 3};
        int n = h.length;

        Stack<Integer> s = new Stack<>();

        int max = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && h[s.peek()] > h[i]) {
                int ht = h[s.pop()];

                int w;
                if (s.isEmpty())
                    w = i;
                else
                    w = i - s.peek() - 1;

                max = Math.max(max, ht * w);
            }

            s.push(i);
        }

        while (!s.isEmpty()) {
            int ht = h[s.pop()];

            int w;
            if (s.isEmpty())
                w = n;
            else
                w = n - s.peek() - 1;

            max = Math.max(max, ht * w);
        }

        System.out.println(max);
    }
}
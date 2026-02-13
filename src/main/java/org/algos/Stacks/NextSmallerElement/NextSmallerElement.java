package org.algos.Stacks.NextSmallerElement;

//Next Smaller Element (NSE):
//For each element in an array, find the nearest element to its right
//that is strictly smaller. If none exists, answer is -1.

//Algorithm Explanation
//
//We traverse the array from right to left
//
//We use a stack to keep elements that are candidates for NSE
//
//For every element:
//
//Remove (pop) all elements from stack ≥ current element
//
//After popping:
//
//If stack is empty → NSE = -1
//
//Else → NSE = top of stack
//
//Push current element into stack
//
//Stack always remains monotonically increasing (bottom → top)

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {4, 8, 5, 2};

        int[] nse = new int[a.length];
        Stack<Integer> st = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= a[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = -1;
            } else {
                nse[i] = st.peek();
            }

            st.push(a[i]);
        }

        for (int x : nse) {
            System.out.print(x + " ");
        }
    }
}
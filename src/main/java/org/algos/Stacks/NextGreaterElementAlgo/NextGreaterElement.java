package org.algos.Stacks.NextGreaterElementAlgo;

//Next Greater Element for an element is the first element to its right that is strictly greater.
//If no such element exists, the answer is -1.

//Algorithm Explanation
//
//Traverse the array from right to left
//
//Use a stack to store possible “greater elements”
//
//For each element:
//
//Remove (pop) all elements from stack ≤ current element
//
//Top of stack (if exists) is the Next Greater Element
//
//If stack is empty → answer is -1
//
//Push current element into stack
//
//Stack always maintains elements in strictly decreasing order

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        for (int x : nge) {
            System.out.println(x + " ");
        }
    }
}
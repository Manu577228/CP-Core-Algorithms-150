package org.algos.Stacks.PreviousGreaterElement;

//For each element in an array, the Previous Greater Element (PGE)
//is the nearest element to its left that is strictly greater than it.
//If no such element exists, the answer is -1.

//Algorithm Explanation
//
//Traverse the array from left to right.
//
//Maintain a monotonic decreasing stack (top always greater candidates).
//
//For the current element:
//
//Pop elements from stack while stack top ≤ current element.
//
//After popping:
//
//If stack is empty → PGE = -1
//
//Else → PGE = stack top
//
//Push the current element into the stack.
//
//Each element is pushed and popped at most once.

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int[] a = {10, 4, 2, 20, 40, 12};

        int n = a.length;

        int[] ans = new int[n];
        int[] st = new int[n];

        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && st[top] <= a[i]) {
                top--;
            }

            if (top == -1) {
                ans[i] = -1;
            } else {
                ans[i] = st[top];
            }

            st[++top] = a[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

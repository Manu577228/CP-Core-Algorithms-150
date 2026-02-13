package org.algos.QueueAndDeque.SlidingWindowMaximumAlgo;

//The Sliding Window Maximum problem finds the maximum element
//in every contiguous subarray (window) of size k while moving the window one step at a time.
//It is optimally solved using a Deque (Double Ended Queue).

//Algorithm Explanation
//
//We use a Deque to store indices, not values
//
//The deque always keeps elements in decreasing order of values
//
//The front of deque always stores the index of the maximum element of current window
//
//For every index i:
//
//Remove indices from front if they are outside the current window
//
//Remove indices from back if their value is smaller than current element
//
//Add current index to the back
//
//If window size ≥ k, record the element at deque front as the maximum

//Example used:
//arr = [1, 3, -1, -3, 5, 3, 6, 7], k = 3

import java.io.*;
import java.util.*;

class SlidingWindowMaximum {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1)
                sb.append(arr[dq.peekFirst()]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
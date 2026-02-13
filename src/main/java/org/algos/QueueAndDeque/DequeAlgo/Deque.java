package org.algos.QueueAndDeque.DequeAlgo;

//A Deque Algorithm uses a double-ended queue to push and pop elements
//from both front and back efficiently.
//It is commonly used to maintain order (min/max) while
//processing elements sequentially.

//How the Algorithm Works :
//
//We store indices in a deque, not values
//
//Deque maintains a monotonic order (increasing or decreasing)
//
//Before adding a new element:
//
//Remove useless elements from the back
//
//Before reading answer:
//
//Remove out-of-range elements from the front
//
//Front of deque always gives the current answer

//Example Problem
// Find maximum in every window of size k = 3
// Array: [1, 3, -1, -3, 5]

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5};
        int k = 3;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1)
                System.out.print(arr[dq.peekFirst()] + " ");
        }
    }
}
package org.algos.QueueAndDeque.MonotonicQueueAlgo;

//A Monotonic Queue is a deque that maintains its elements in monotonic
//        order (increasing or decreasing).
//It allows O(1) access to the minimum or maximum element in a sliding window.

//Algorithm Explanation
//
//        Monotonic Increasing Queue (for minimum):
//
//        Queue always stores elements in increasing order
//
//        Front → minimum element
//
//        Back → largest candidate
//
//        Rules:
//
//        Remove bigger elements from back before adding new
//
//        Remove out-of-window element from front
//
//        Front always gives current minimum

//Example: Sliding Window Minimum
//        Array = [4, 2, 12, 3, 1], Window size = 2

import java.util.*;

class MonotonicQueueMin {
    public static void main(String[] args) {
        int[] a = {4, 2, 12, 3, 1};
        int k = 2;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < a.length; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }

            while (!q.isEmpty() && a[q.peekLast()] > a[i]) {
                q.pollLast();
            }

            q.addLast(i);

            if (i >= k - 1) {
                System.out.print(a[q.peekFirst()] + " ");
            }
        }
    }
}

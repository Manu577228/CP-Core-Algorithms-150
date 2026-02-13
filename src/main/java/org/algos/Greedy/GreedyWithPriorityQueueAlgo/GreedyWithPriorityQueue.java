package org.algos.Greedy.GreedyWithPriorityQueueAlgo;

//      Greedy with Priority Queue is an algorithmic technique where
//      we repeatedly make the best local choice using a Priority Queue to always
//      access the most optimal element (minimum or maximum) efficiently.
//      It works when local optimal decisions lead to a global optimal solution.


//          Algorithm Explanation
//
//      Store elements in a Priority Queue (min-heap or max-heap).
//
//      At every step, pick the best element (top of heap).
//
//      Process it and update the queue if required.
//
//      Repeat until the queue is empty or condition is met.

//       Connect ropes with minimum cost(classic Greedy+PQ)

import java.util.PriorityQueue;

class GreedyWithPQ {
    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int r : ropes) {
            pq.add(r);
        }

        int totalCost = 0;

        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;
            totalCost += cost;

            pq.add(cost);
        }

        System.out.println(totalCost);
    }
}
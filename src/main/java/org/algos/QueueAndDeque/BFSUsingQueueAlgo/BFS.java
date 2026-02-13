package org.algos.QueueAndDeque.BFSUsingQueueAlgo;

//Breadth First Search (BFS) is a graph traversal algorithm that explores nodes level by level.
//
//        It uses a Queue (FIFO) to visit all immediate neighbors before going deeper.

//BFS Algorithm
//
//        Start from a source node
//
//        Mark it as visited
//
//        Push it into a queue
//
//        While queue is not empty
//
//        Remove (dequeue) front node
//
//        Process it
//
//        Push all unvisited neighbors into queue and mark them visited
//
//        Continue until queue becomes empty

//Graph: 0 → {1, 2}, 1 → {3}, 2 → {}, 3 → {}

import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 4;

        int[][] g = {
                {1, 2},
                {3},
                {},
                {}
        };

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : g[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }
}

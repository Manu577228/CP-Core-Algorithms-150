package org.algos.Graphs.BFSAlgo;

//Breadth First Search (BFS) is a graph traversal algorithm that explores nodes level by level.
//
//        It visits all immediate neighbors first before moving to the next depth.

//            BFS Algorithm
//
//        Start from a source node
//
//        Use a queue to maintain traversal order
//
//        Mark the source as visited
//
//        Repeat until queue is empty:
//
//        Remove front node
//
//        Visit all unvisited neighbors
//
//        Mark them visited and push into queue
//
//        Ensures minimum distance (levels) from source

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int n = 5;

        int[][] g = {
                {1, 2},
                {0, 3},
                {0, 4},
                {1},
                {2}
        };

        boolean[] vis = new boolean[n];

        ArrayDeque<Integer> q = new ArrayDeque<>();

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

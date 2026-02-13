package org.algos.Graphs.MultiSourceBFSAlgo;

//Multi-Source BFS is a BFS where traversal starts simultaneously from multiple source nodes.
//        It computes the minimum distance from the nearest source to
//        every node in an unweighted graph.

//          Algorithm Explanation
//
//        Put all source nodes into the queue initially
//
//        Mark all sources as visited with distance 0
//
//        Perform normal BFS
//
//        Every node is reached from the closest source first
//
//        BFS guarantees minimum distance because graph is unweighted

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        int n = 6;

        int[][] g = {
                {1, 2},
                {0, 3},
                {0, 3},
                {1, 2, 4},
                {3, 5},
                {4}
        };

        int[] src = {0, 4};

        int[] d = new int[n];

        Arrays.fill(d, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int s : src) {
            q.add(s);
            d[s] = 0;
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : g[u]) {
                if (d[v] == -1) {
                    d[v] = d[u] + 1;
                    q.add(v);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);

        for (int i = 0; i < n; i++) {
            out.println("Node " + i + " -> Distance " + d[i]);
        }

        out.flush();
    }
}
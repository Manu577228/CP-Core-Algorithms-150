package org.algos.Graphs.DijkstrasAlgo;

//Dijkstra’s Algorithm finds the shortest path from a
//        single source to all other nodes in a graph with non-negative edge weights.
//        It greedily expands the nearest unvisited node.

//           Algorithm
//
//        Initialize all distances as infinity
//
//        Set source distance = 0
//
//        Use PriorityQueue to always pick node with minimum distance
//
//        Relax all adjacent edges
//
//        Update distance if a shorter path is found
//
//        Repeat until all nodes are processed

import java.io.*;
import java.util.*;

class Main {

    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 5;

        List<Edge>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        g[0].add(new Edge(1, 2)); // edge 0 -> 1 with weight 2
        g[0].add(new Edge(2, 4)); // edge 0 -> 2 with weight 4
        g[1].add(new Edge(2, 1)); // edge 1 -> 2 with weight 1
        g[1].add(new Edge(3, 7)); // edge 1 -> 3 with weight 7
        g[2].add(new Edge(4, 3)); // edge 2 -> 4 with weight 3
        g[3].add(new Edge(4, 1)); // edge 3 -> 4 with weight 1

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        dist[0] = 0;
        pq.add(new int[]{
                0, 0
        });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (Edge e : g[u]) {
                int v = e.v;
                int w = e.w;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{
                            v, dist[v]
                    });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("0 -> " + i + " = " + dist[i]);
        }
    }
}

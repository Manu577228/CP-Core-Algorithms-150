package org.algos.Graphs.BellmanFordAlgo;

//Bellman–Ford is a single-source shortest path algorithm that works on weighted graphs.
//        It can handle negative edge weights and can detect negative weight cycles.
//
//             How the Algorithm Works
//
//        Initialize distance of source as 0, all other vertices as ∞
//
//        Repeat V − 1 times:
//
//        For every edge (u → v, wt)
//
//        If dist[u] + wt < dist[v], update dist[v]
//
//        Do one extra iteration:
//
//        If any distance still reduces → negative cycle exists
//
//        Reason for V − 1:
//
//        Maximum edges in shortest path without cycle = V − 1

import java.io.*;
import java.util.*;

class BellmanFord {

    static class Edge {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {

        int V = 3;

        Edge[] edges = new Edge[3];
        edges[0] = new Edge(0, 1, 4);
        edges[1] = new Edge(0, 2, 5);
        edges[2] = new Edge(1, 2, -3);

        int src = 0;

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                        dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        boolean negCycle = false;

        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.w < dist[e.v]) {
                negCycle = true;
                break;
            }
        }

        if (negCycle) {
            System.out.println("Negative Weight Cycle Detected!");
        } else {
            for (int i = 0; i < V; i++) {
                System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
            }
        }
    }
}


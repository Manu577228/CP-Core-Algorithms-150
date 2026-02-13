package org.algos.Graphs.BFS01Algo;

//0–1 BFS is a shortest path algorithm for graphs where every edge weight is either 0 or 1.
//        It uses a Deque instead of a priority queue to achieve linear time complexity.

//         How the Algorithm Works
//
//        Works on graphs with edge weights only 0 or 1
//
//        Uses a Deque (Double Ended Queue)
//
//        Start from source, distance[source] = 0
//
//        When relaxing an edge:
//
//        If weight = 0 → push node to front of deque
//
//        If weight = 1 → push node to back of deque
//
//        Always process the front of deque
//
//        Ensures shortest distance without Dijkstra’s overhead

import java.io.*;
import java.util.*;

class Main {

    static class Edge {
        int to;
        int wt;

        Edge(int t, int w) {
            to = t;
            wt = w;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 4;

        List<Edge>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        g[0].add(new Edge(1, 0));
        g[0].add(new Edge(2, 1));
        g[1].add(new Edge(2, 1));
        g[1].add(new Edge(3, 0));
        g[2].add(new Edge(3, 0));

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();

        int src = 0;
        dist[src] = 0;
        dq.addFirst(src);

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (Edge e : g[u]) {
                int v = e.to;
                int w = e.wt;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;

                    if (w == 0)
                        dq.addFirst(v);
                    else
                        dq.addLast(v);
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++)
            out.println("Distance from 0 to " + i + " = " + dist[i]);
        out.flush();
    }
}

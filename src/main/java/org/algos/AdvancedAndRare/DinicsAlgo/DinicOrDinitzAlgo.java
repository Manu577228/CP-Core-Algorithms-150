package org.algos.AdvancedAndRare.DinicsAlgo;

//          Dinic’s Algorithm is a fast algorithm to compute the
//          maximum flow in a flow network.
//          It improves Ford–Fulkerson by using BFS to build level
//          graphs and DFS to send blocking flows, reducing unnecessary searches.
//
//          Algorithm Explanation
//
//          Use BFS from source to build a level graph (shortest distance to sink).
//
//          Use DFS on this level graph to push maximum possible flow (blocking flow).
//
//          Repeat BFS + DFS until sink becomes unreachable.

import java.io.*;
import java.util.*;

class Main {

    static class Edge {
        int v;
        int flow;
        int cap;
        int rev;

        Edge(int v, int cap, int rev) {
            this.v = v;
            this.cap = cap;
            this.rev = rev;
            this.flow = 0;
        }
    }

    static int n;
    static ArrayList<Edge>[] g;
    static int[] level;
    static int[] it;

    static void addEdge(int u, int v, int cap) {
        g[u].add(new Edge(v, cap, g[v].size()));
        g[v].add(new Edge(u, cap, g[u].size() - 1));
    }

    static boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        Queue<Integer> q = new ArrayDeque<>();

        level[s] = 0;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (Edge e : g[u]) {
                if (level[e.v] < 0 && e.flow < e.cap) {
                    level[e.v] = level[u] + 1;
                    q.add(e.v);
                }
            }
        }

        return level[t] >= 0;
    }

    static int dfs(int u, int t, int f) {
        if (u == t) return f;

        for (; it[u] < g[u].size(); it[u]++) {
            Edge e = g[u].get(it[u]);

            if (e.flow < e.cap && level[e.v] == level[u] + 1) {
                int pushed = dfs(
                        e.v,
                        t,
                        Math.min(f, e.cap - e.flow)
                );

                if (pushed > 0) {
                    e.flow += pushed;
                    g[e.v].get(e.rev).flow -= pushed;
                    return pushed;
                }
            }
        }

        return 0;
    }

    static int maxflow(int s, int t) {
        int flow = 0;

        while (bfs(s, t)) {
            Arrays.fill(it, 0);
            int pushed;

            while ((pushed = dfs(s, t, Integer.MAX_VALUE)) > 0) {
                flow += pushed;
            }
        }

        return flow;
    }

    public static void main(String[] args) {
        n = 4;
        g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        level = new int[n];
        it = new int[n];


        addEdge(0, 1, 3);
        addEdge(0, 2, 2);
        addEdge(1, 2, 1);
        addEdge(1, 3, 2);
        addEdge(2, 3, 4);

        System.out.println(maxflow(0, 3));

    }
}
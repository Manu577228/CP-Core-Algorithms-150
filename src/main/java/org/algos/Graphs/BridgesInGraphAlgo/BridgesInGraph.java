package org.algos.Graphs.BridgesInGraphAlgo;

//A bridge is an edge whose removal increases the number of connected components in a graph.
//        Removing a bridge disconnects part of the graph.

//           Algorithm Explanation
//
//        Use DFS and track discovery time of each node.
//
//        Maintain two arrays:
//
//        tin[u] → time when node u is first visited
//
//        low[u] → earliest visited node reachable from u
//
//        For every edge u → v:
//
//        If v is not visited → DFS on v
//
//        Update low[u] = min(low[u], low[v])
//
//        If low[v] > tin[u] → edge (u, v) is a bridge
//
//        Ignore the edge going back to the parent.

import java.util.*;

class Main {

    static int n = 5;
    static ArrayList<Integer>[] g;
    static int[] tin, low;
    static boolean[] vis;
    static int timer = 0;

    static void dfs(int u, int p) {
        vis[u] = true;
        tin[u] = low[u] = timer++;

        for (int v : g[u]) {
            if (v == p) continue;

            if (!vis[v]) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > tin[u])
                    System.out.println(u + " - " + v + " is a bridge");
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        g[0].add(1);
        g[1].add(0);
        g[1].add(2);
        g[2].add(1);
        g[1].add(3);
        g[3].add(1);
        g[3].add(4);
        g[4].add(3);

        tin = new int[n];
        low = new int[n];
        vis = new boolean[n];

        dfs(0, -1);
    }
}
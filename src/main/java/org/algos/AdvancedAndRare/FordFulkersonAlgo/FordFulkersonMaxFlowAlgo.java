package org.algos.AdvancedAndRare.FordFulkersonAlgo;

//          Ford–Fulkerson Algorithm computes the maximum flow from a source
//          to a sink in a flow network by repeatedly finding augmenting paths and
//          increasing flow along them until no such path exists.
//
//          Algorithm Explanation (extremely concise & clear)
//
//          Start with zero flow on all edges
//
//          Repeatedly find a path from source to sink with available capacity
//
//          Push the minimum capacity (bottleneck) along that path
//
//          Update residual capacities
//
//          Stop when no path exists


import java.io.*;
import java.util.*;

class Main {

    static int V;
    static int[][] r;
    static boolean[] vis;

    static boolean dfs(int u, int t, int[] p) {
        if (u == t) return true;

        vis[u] = true;

        for (int v = 0; v < V; v++) {
            if (!vis[v] && r[u][v] > 0) {
                p[v] = u;
                if (dfs(v, t, p)) return true;
            }
        }

        return false;
    }

    static int fordFulkerson(int[][] g, int s, int t) {
        r = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                r[i][j] = g[i][j];

        int maxFlow = 0;
        int[] p = new int[V];

        while (true) {
            vis = new boolean[V];

            if (!dfs(s, t, p)) break;

            int flow = Integer.MAX_VALUE;

            for (int v = t; v != s; v = p[v])
                flow = Math.min(flow, r[p[v]][v]);

            for (int v = t; v != s; v = p[v]) {
                r[p[v]][v] -= flow;
                r[v][p[v]] += flow;
            }

            maxFlow += flow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        V = 6;

        int[][] g = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        int s = 0, t = 5;

        System.out.println(fordFulkerson(g, s, t));
    }
}
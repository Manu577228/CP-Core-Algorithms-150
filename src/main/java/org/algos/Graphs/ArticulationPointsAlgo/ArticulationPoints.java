package org.algos.Graphs.ArticulationPointsAlgo;

//An Articulation Point is a vertex whose removal increases
//        the number of connected components in a graph.
//        Removing it breaks connectivity of the graph.

//         Algorithm Explanation :
//
//        Idea (DFS + Time Tracking):
//
//        Run DFS and assign each node a discovery time (tin)
//
//        Maintain lowest reachable time (low) from subtree
//
//        A node is an articulation point if:
//
//        Root node has 2 or more DFS children
//
//        Non-root node has a child such that
//        low[child] >= tin[current]
//
//        Why this works:
//
//        low[child] tells whether the child subtree can reach an ancestor
//
//        If it cannot, removing current node disconnects that subtree

import java.util.*;

class ArticulationPoint {

    static int n;
    static List<Integer>[] g;
    static int[] tin, low;
    static boolean[] vis, ap;
    static int timer = 0;

    static void dfs(int u, int p) {
        vis[u] = true;
        tin[u] = low[u] = ++timer;
        int child = 0;

        for (int v : g[u]) {
            if (v == p) continue;

            if (!vis[v]) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                if (p != -1 && low[v] >= tin[u])
                    ap[u] = true;

                child++;
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        if (p == -1 && child > 1)
            ap[u] = true;
    }

    public static void main(String[] args) {
        n = 5;
        g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(3, 4);

        tin = new int[n];
        low = new int[n];
        vis = new boolean[n];
        ap = new boolean[n];

        dfs(0, -1);

        System.out.println("Articulation Points:");
        for (int i = 0; i < n; i++) {
            if (ap[i]) System.out.println(i);
        }
    }

    static void addEdge(int u, int v) {
        g[u].add(v);
        g[v].add(u);
    }
}

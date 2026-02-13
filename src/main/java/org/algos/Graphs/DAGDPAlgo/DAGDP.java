package org.algos.Graphs.DAGDPAlgo;

//DAG DP is a dynamic programming technique applied on a Directed Acyclic Graph,
// where each node’s value depends on its predecessors.
//Since there are no cycles, nodes can be processed in topological order,
// ensuring subproblems are solved before being used.

//Algorithm Explanation
//
//Perform Topological Sort of the DAG
//
//Initialize DP array for each node
//
//Traverse nodes in topological order
//
//Relax edges and update DP values using transitions

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

    static void dfs(int u, boolean[] vis, Stack<Integer> st, List<Edge>[] g) {
        vis[u] = true;
        for (Edge e : g[u]) {
            if (!vis[e.v])
                dfs(e.v, vis, st, g);

        }

        st.push(u);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = 6;
        int m = 7;

        List<Edge>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        g[0].add(new Edge(1, 5));
        g[0].add(new Edge(2, 3));
        g[1].add(new Edge(3, 6));
        g[1].add(new Edge(2, 2));
        g[2].add(new Edge(4, 4));
        g[2].add(new Edge(5, 2));
        g[2].add(new Edge(3, 7));

        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
            if (!vis[i])
                dfs(i, vis, st, g);

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        while (!st.isEmpty()) {
            int u = st.pop();
            if (dp[u] != Integer.MIN_VALUE) {
                for (Edge e : g[u]) {
                    dp[e.v] = Math.max(dp[e.v], dp[u] + e.w);
                }
            }
        }

        for (int i = 0; i < n; i++)
            out.println("Longest path to node " + i + " = " + dp[i]);

        out.flush();
    }
}

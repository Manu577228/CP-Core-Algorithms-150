package org.algos.Graphs.TreeDpAlgo;

//Tree DP is a dynamic programming technique applied on t
//rees where each node computes answers using results from its children.
//It relies on DFS traversal and exploits the no-cycle
//property of trees to avoid recomputation.

//Algorithm Explanation
//
//Root the tree at any node (usually 0 or 1)
//
//Use DFS to visit children
//
//For each node, compute DP value using children’s DP values
//
//Return DP value to parent
//
//👉 In this example:
//dp[node] = value[node] + sum of dp[children]

import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[] val;
    static int[] dp;
    static int[] head, to, next;
    static int idx = 0;

    static void addEdge(int u, int v) {
        to[idx] = v;
        next[idx] = head[u];
        head[u] = idx;
        idx++;
    }

    static void dfs(int u, int p) {
        dp[u] = val[u];

        for (int i = head[u]; i != -1; i = next[i]) {
            int v = to[i];
            if (v == p) continue;
            dfs(v, u);
            dp[u] += dp[v];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        n = 5;

        val = new int[]{1, 2, 3, 4, 5};
        dp = new int[n];
        head = new int[n];
        to = new int[2 * (n - 1)];
        next = new int[2 * (n - 1)];

        Arrays.fill(head, -1);

        addEdge(0, 1);
        addEdge(1, 0);
        addEdge(0, 2);
        addEdge(2, 0);
        addEdge(1, 3);
        addEdge(3, 1);
        addEdge(1, 4);
        addEdge(4, 1);

        dfs(0, -1);

        for (int i = 0; i < n; i++)
            out.print(dp[i] + " ");

        out.flush();
    }
}
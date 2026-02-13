package org.algos.Graphs.TarjansAlgo;

//Tarjan’s SCC Algorithm finds all Strongly Connected Components in a
//        directed graph using one DFS traversal.
//        A Strongly Connected Component is a group of nodes where
//        each node is reachable from every other node.

//        Algorithm Explanation
//
//        Perform DFS on the graph.
//
//        Assign each node:
//
//        disc[u] → discovery time
//
//        low[u] → lowest discovery time reachable
//
//        Maintain a stack of active DFS nodes.
//
//        While returning from DFS:
//
//        Update low[u] using neighbors.
//
//        If disc[u] == low[u]:
//
//        u is the root of an SCC
//
//        Pop nodes from stack until u is removed → one SCC formed.

import java.util.*;

class TarjanSCC {

    static int n = 4;
    static List<Integer>[] g = new ArrayList[n];

    static int time = 0;
    static int[] disc = new int[n];
    static int[] low = new int[n];
    static boolean[] inStack = new boolean[n];

    static Deque<Integer> st = new ArrayDeque<>();

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        g[0].add(1);
        g[1].add(2);
        g[2].add(0);
        g[2].add(3);

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) dfs(i);
        }
    }

    static void dfs(int u) {
        disc[u] = low[u] = time++;
        st.push(u);
        inStack[u] = true;

        for (int v : g[u]) {
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (disc[u] == low[u]) {
            System.out.print("SCC: ");
            while (true) {
                int x = st.pop();
                inStack[x] = false;
                System.out.print(x + " ");
                if (x == u) break;
            }

            System.out.println();
        }
    }
}
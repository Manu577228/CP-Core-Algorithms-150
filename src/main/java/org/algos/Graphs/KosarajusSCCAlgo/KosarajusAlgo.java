package org.algos.Graphs.KosarajusSCCAlgo;

//Kosaraju’s Algorithm is used to find all Strongly Connected Components
//        (SCCs) in a directed graph.
//        An SCC is a group of vertices where every vertex is
//        reachable from every other vertex.

//             Algorithm Explanation
//
//        Perform DFS on the original graph to compute finishing order of nodes
//
//        Push nodes into a stack after all neighbors are fully explored
//
//        Reverse all edges of the graph (Transpose Graph)
//
//        Pop nodes one by one from the stack
//
//        For every unvisited popped node, run DFS on transpose graph
//
//        All nodes visited in this DFS form one SCC

import java.util.*;

class KosarajuSCC {

    static void dfs1(int u, boolean[] vis, List<Integer>[] g, Stack<Integer> st) {
        vis[u] = true;

        for (int v : g[u]) {
            if (!vis[v]) {
                dfs1(v, vis, g, st);
            }
        }

        st.push(u);
    }

    static void dfs2(int u, boolean[] vis, List<Integer>[] gt, List<Integer> comp) {
        vis[u] = true;
        comp.add(u);

        for (int v : gt[u]) {
            if (!vis[v]) {
                dfs2(v, vis, gt, comp);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 4;

        List<Integer>[] g = new ArrayList[n];
        List<Integer>[] gt = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            gt[i] = new ArrayList<>();
        }

        g[0].add(1);
        g[1].add(2);
        g[2].add(0);
        g[1].add(3);

        for (int u = 0; u < n; u++) {
            for (int v : g[u]) {
                gt[v].add(u);
            }
        }

        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs1(i, vis, g, st);
            }
        }

        Arrays.fill(vis, false);

        while (!st.isEmpty()) {
            int u = st.pop();

            if (!vis[u]) {
                List<Integer> comp = new ArrayList<>();
                dfs2(u, vis, gt, comp);
                System.out.println(comp);
            }
        }
    }
}



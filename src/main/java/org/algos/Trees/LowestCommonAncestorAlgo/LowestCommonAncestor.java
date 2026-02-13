package org.algos.Trees.LowestCommonAncestorAlgo;

//The Lowest Common Ancestor (LCA) of two nodes u and v in
//        a tree is the deepest node that is an ancestor of both u and v.

//          Algorithm Explanation
//
//        Root the tree (usually at node 0 or 1)
//
//        Store parent and depth of every node using DFS
//
//        If depths differ, lift the deeper node up until both are at same depth
//
//        Move both nodes up together until they meet
//
//        The meeting node is the LCA

import java.io.*;
import java.util.*;

class Main {

    static int N = 7;
    static int[] parent = new int[N];
    static int[] depth = new int[N];
    static List<Integer>[] g;

    static void dfs(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, d + 1);
            }
        }
    }

    static int lca(int u, int v) {
        while (depth[u] > depth[v]) {
            u = parent[u];
        }

        while (depth[v] > depth[u]) {
            v = parent[v];
        }

        while (u != v) {
            u = parent[u];
            v = parent[v];
        }

        return u;
    }

    public static void main(String[] args) {
        g = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }

        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}
        };

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(0, -1, 0);

        int u = 3, v = 4;
        System.out.println(lca(u, v));
    }
}
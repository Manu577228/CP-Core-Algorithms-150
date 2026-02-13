package org.algos.Trees.DSUOnTreesAlgo;

//        DSU on Trees is a tree algorithm used to efficiently
//        answer subtree queries by merging smaller subtree data into larger ones.
//        It optimizes repeated subtree computations using
//        the small-to-large merging technique.

//        How the Algorithm Works
//
//        Root the tree at node 1
//
//        For every node, you want to compute some information about its entire subtree
//
//        Each node maintains a data structure (usually frequency/count map)
//
//        While returning from DFS:
//
//        Always keep the largest child’s data
//
//        Merge all smaller children’s data into the largest one
//
//        This guarantees that each element moves only O(log N) times overall
//
//        Result: subtree queries handled efficiently without recomputation

//Example Tree
//
//        1
//        ├── 2
//        │   ├── 4
//        │   └── 5
//        └── 3
//
//        Colors
//
//        1 → 1
//        2 → 2
//        3 → 1
//        4 → 3
//        5 → 2

import java.io.*;
import java.util.*;

class Main {

    static List<Integer>[] g;
    static int[] col;
    static Map<Integer, Integer>[] mp;
    static int[] ans;

    static void dfs(int u, int p) {
        mp[u] = new HashMap<>();
        mp[u].put(col[u], 1);

        for (int v : g[u]) {
            if (v == p) continue;

            dfs(v, u);

            if (mp[u].size() < mp[v].size()) {
                Map<Integer, Integer> t = mp[u];
                mp[u] = mp[v];
                mp[v] = t;
            }

            for (int c : mp[v].keySet()) {
                mp[u].put(c, mp[u].getOrDefault(c, 0) + mp[v].get(c));
            }
        }

        ans[u] = mp[u].size();
    }

    public static void main(String[] args) {
        int n = 5;

        g = new ArrayList[n + 1];
        col = new int[n + 1];
        mp = new HashMap[n + 1];
        ans = new int[n + 1];

        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        g[1].add(2);
        g[2].add(1);
        g[1].add(3);
        g[3].add(1);
        g[2].add(4);
        g[4].add(2);
        g[2].add(5);
        g[5].add(2);

        col[1] = 1;
        col[2] = 2;
        col[3] = 1;
        col[4] = 3;
        col[5] = 2;

        dfs(1, 0);

        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + " -> " + ans[i]);
        }
    }
}



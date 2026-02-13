package org.algos.Graphs.CycleDetectiondirectedGraphAlgo;

//Cycle detection in a directed graph checks whether there
// exists a path where a node is revisited before its DFS call finishes.
//        It indicates infinite dependency / deadlock / invalid ordering.

//        Algorithm Explanation :
//
//        Use DFS traversal
//
//        Maintain two boolean arrays
//
//        vis[] → node already visited
//
//        path[] → node currently in recursion stack
//
//        While DFS:
//
//        Mark node as visited and add to current path
//
//        If an adjacent node is:
//
//        not visited → DFS on it
//
//        already in path[] → cycle detected
//
//        After DFS finishes for a node:
//
//        Remove it from path[]

import java.io.*;
import java.util.*;

class Main {

    static boolean dfs(int u, List<Integer>[] g, boolean[] vis, boolean[] path) {
        vis[u] = true;
        path[u] = true;

        for (int v : g[u]) {
            if (!vis[v]) {
                if (dfs(v, g, vis, path)) return true;
            } else if (path[v]) {
                return true;
            }
        }

        path[u] = false;
        return false;
    }

    public static void main(String[] args) throws Exception {

        int n = 3;
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        g[0].add(1);
        g[1].add(2);
        g[2].add(0);

        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];

        boolean cycle = false;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (dfs(i, g, vis, path)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println(cycle ? "Cycle Detected" : "No Cycle");
    }
}
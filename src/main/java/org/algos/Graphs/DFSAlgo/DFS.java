package org.algos.Graphs.DFSAlgo;

//Depth First Search (DFS) is a graph traversal algorithm
//        that explores as far as possible along one path before backtracking.
//        It uses recursion or an explicit stack to visit nodes deeply.

//           DFS Algorithm
//
//        Start from a source node
//
//        Mark the current node as visited
//
//        Process the current node
//
//        Recursively visit all unvisited neighbors one by one
//
//        Backtrack when no unvisited neighbor is left

import java.io.*;
import java.util.*;

class Main {

    static ArrayList<Integer>[] g;
    static boolean[] vis;

    static void dfs(int u) {
        vis[u] = true;
        System.out.print(u + " ");

        for (int v : g[u]) {
            if (!vis[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 4;

        g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

            g[0].add(1);
            g[0].add(2);
            g[1].add(3);

            vis = new boolean[n];

            dfs(0);
        }
    }



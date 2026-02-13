package org.algos.Trees.TreeDiamaterAlgo;

//        Tree Diameter is the longest distance (number of edges)
//        between any two nodes in a tree.
//        The path does not need to pass through the root.

//           Algorithm Explanation
//
//        Key Idea: Two DFS / BFS technique
//
//        Pick any node in the tree (say node 0)
//
//        Run DFS/BFS → find the farthest node from it (A)
//
//        From node A, run DFS/BFS again
//
//        The maximum distance found in second traversal is the tree diameter
//
//        Why it works
//
//        One end of the diameter is always the farthest node from any arbitrary node
//
//        Second traversal measures the full longest path

import java.util.*;

class TreeDiameter {

    static List<Integer>[] g;
    static int farNode;
    static int maxDist;

    static void dfs(int u, int p, int d) {
        if (d > maxDist) {
            maxDist = d;
            farNode = u;
        }

        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, d + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        g[0].add(1);
        g[1].add(0);
        g[0].add(2);
        g[2].add(0);
        g[2].add(3);
        g[3].add(2);

        maxDist = 0;
        dfs(0, -1, 0);

        int start = farNode;

        maxDist = 0;
        dfs(start, -1, 0);

        System.out.println("Tree Diameter = " + maxDist);
    }
}

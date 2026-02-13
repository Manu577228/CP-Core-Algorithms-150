package org.algos.Trees.CentroidDecompositionAlgo;

//       Centroid Decomposition is a divide-and-conquer technique on
//        trees where we repeatedly remove a centroid node so that all resulting
//        subtrees have size ≤ N/2.
//        This converts a tree problem into smaller independent subproblems.

//              Algorithm Explanation
//
//        A centroid of a tree is a node whose removal splits the tree
//        into subtrees of size at most half.
//
//        Step 1: Compute subtree sizes using DFS.
//
//        Step 2: Find the centroid using subtree sizes.
//
//        Step 3: Mark the centroid as “removed”.
//
//        Step 4: Recursively apply the same process to each remaining subtree.
//
//        The recursion builds a Centroid Tree.

import java.io.*;
import java.util.*;

class Main {

    static int n;
    static List<Integer>[] g;
    static boolean[] removed;
    static int[] sz;

    static void dfsSize(int u, int p) {
        sz[u] = 1;
        for (int v : g[u]) {
            if (v != p && !removed[v]) {
                dfsSize(v, u);
                sz[u] += sz[v];
            }
        }
    }

    static int dfsCentroid(int u, int p, int tot) {
        for (int v : g[u]) {
            if (v != p && !removed[v] && sz[v] > tot / 2) {
                return dfsCentroid(v, u, tot);
            }
        }

        return u;
    }

    static void decompose(int entry) {
        dfsSize(entry, -1);
        int c = dfsCentroid(entry, -1, sz[entry]);

        System.out.println("Centroid: " + c);

        removed[c] = true;

        for (int v : g[c]) {
            if (!removed[v]) {
                decompose(v);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        n = 5;
        g = new ArrayList[n + 1];
        removed = new boolean[n + 1];
        sz = new int[n + 1];

        for(int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        g[1].add(2); g[2].add(1);
        g[1].add(3); g[3].add(1);
        g[3].add(4); g[4].add(3);
        g[3].add(5); g[5].add(3);

        decompose(1);
    }
}

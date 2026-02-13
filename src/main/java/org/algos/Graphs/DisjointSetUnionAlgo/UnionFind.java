package org.algos.Graphs.DisjointSetUnionAlgo;

//Union Find (Disjoint Set Union – DSU) is a data structure used to
//        track connected components in a graph.
//        It supports fast union (merge sets) and find
//        (check parent / connectivity) operations.

//          How the Algorithm Works
//
//        Each node initially belongs to its own set
//
//        Every set has a representative (parent/root)
//
//        Find(x)
//
//        Follows parent pointers to reach the root
//
//        Uses path compression to flatten the structure
//
//        Union(a, b)
//
//        Finds roots of a and b
//
//        Attaches smaller tree under larger tree (union by rank)
//
//        Used heavily in cycle detection, connected components, Kruskal’s MST

import java.io.*;
import java.util.*;

class Main {

    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }

    public static void main(String[] args) throws Exception {

        int n = 5;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        union(0, 1);
        union(1, 2);
        union(3, 4);

        System.out.println(find(0) == find(2));
        System.out.println(find(0) == find(4));
    }
}
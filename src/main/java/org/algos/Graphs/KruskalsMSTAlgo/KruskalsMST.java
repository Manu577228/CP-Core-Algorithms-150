package org.algos.Graphs.KruskalsMSTAlgo;

//Kruskal’s Algorithm is a greedy algorithm used to find the Minimum
//        Spanning Tree (MST) of a weighted, undirected graph.
//        It selects edges in increasing weight order, avoiding cycles
//        using Disjoint Set Union (DSU).

//          Algorithm Explanation
//
//        Sort all graph edges by ascending weight
//
//        Initialize DSU (Union-Find) for cycle detection
//
//        Pick the smallest edge
//
//        If it connects two different components, include it in MST
//
//        Union those components
//
//        Repeat until V − 1 edges are selected

import java.util.*;

class KruskalMST {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    public static void main(String[] args) {

        int V = 4;

        Edge[] edges = {
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        };

        Arrays.sort(edges);

        parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int mstCost = 0;
        int edgeCount = 0;

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                mstCost += e.w;
                union(e.u, e.v);
                edgeCount++;
                if (edgeCount == V - 1) break;
            }
        }

        System.out.println("MST Cost = " + mstCost);
    }
}

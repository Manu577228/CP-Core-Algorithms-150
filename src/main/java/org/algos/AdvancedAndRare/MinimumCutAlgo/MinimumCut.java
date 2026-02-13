package org.algos.AdvancedAndRare.MinimumCutAlgo;

//          The Minimum Cut Algorithm finds the minimum number
//          of edges that, if removed, disconnect a graph into two components.
//          David Karger proposed a randomized contraction-based
//          approach to solve this problem efficiently with high probability.


//          Algorithm Explanation
//
//          Core Idea → Random Contraction
//
//          While more than 2 vertices remain:
//
//          Pick a random edge.
//
//          Merge (contract) the two vertices of that edge.
//
//          Remove self-loops.
//
//          When only 2 vertices remain:
//
//          The remaining edges between them = Minimum Cut.
//
//          Because it's randomized, we repeat multiple times to improve accuracy.

import java.util.*;
import java.io.*;

class MinimumCut {

    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;

        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[E];
        }
    }

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    static int KergerMinCut(Graph graph) {
        int V = graph.V;
        int E = graph.E;
        Edge[] edges = graph.edges;

        int parent[] = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int vertices = V;

        Random rand = new Random();

        while (vertices > 2) {
            int i = rand.nextInt(E);

            int subset1 = find(parent, edges[i].src);
            int subset2 = find(parent, edges[i].dest);

            if (subset1 == subset2)
                continue;

            else {
                union(parent, subset1, subset2);
                vertices--;
            }
        }

        int cutEdges = 0;

        for (int i = 0; i < E; i++) {
            int subset1 = find(parent, edges[i].src);
            int subset2 = find(parent, edges[i].dest);

            if (subset1 != subset2)
                cutEdges++;
        }

        return cutEdges;

    }


    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        Graph graph = new Graph(V, E);

        graph.edges[0] = new Edge(0, 1);
        graph.edges[1] = new Edge(0, 2);
        graph.edges[2] = new Edge(1, 2);
        graph.edges[3] = new Edge(1, 3);
        graph.edges[4] = new Edge(2, 3);

        System.out.println("Minimum Cut = " + KergerMinCut(graph));
    }
}

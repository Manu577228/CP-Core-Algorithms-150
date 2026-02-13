package org.algos.Graphs.GraphRepresentationAlgo;

//        Graph representation is the way we store vertices and
//        edges in memory so that graph algorithms can efficiently
//        traverse and process connections.
//        The two most common forms are Adjacency List and Adjacency Matrix.

//       How the Algorithm (Adjacency List) Works
//
//        Each node (vertex) is given an index (0 to V-1)
//
//        For every node, we maintain a list of its directly connected neighbors
//
//        When an edge u → v exists:
//
//        Add v to u’s list
//
//        If graph is undirected, also add u to v’s list
//
//        This structure allows:
//
//        Fast traversal of neighbors
//
//        Memory efficiency for sparse graphs

//Example Graph
//        Vertices = 3 → {0, 1, 2}
//        Edges = (0-1), (0-2)


import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int V = 3;
        List<Integer>[] g = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            g[i] = new ArrayList<>();
        }

        g[0].add(1);
        g[1].add(0);
        g[0].add(2);
        g[2].add(0);

        PrintWriter out = new PrintWriter(System.out);

        for (int i = 0; i < V; i++) {
            out.print(i + " -> ");
            for (int x : g[i]) {
                out.print(x + " ");
            }

            out.println();
        }

        out.flush();
    }
}
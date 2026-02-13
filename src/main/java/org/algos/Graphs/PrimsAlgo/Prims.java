package org.algos.Graphs.PrimsAlgo;

//Prim’s Algorithm is a greedy graph algorithm used to find the Minimum Spanning Tree
//        (MST) of a connected, weighted, undirected graph.
//        It grows the MST by always picking the minimum weight
//        edge that connects a visited node to an unvisited node.

//          How the Algorithm Works
//
//       Start from any node and mark it as visited
//
//        Consider all edges from visited nodes to unvisited nodes
//
//      Pick the edge with minimum weight among them
//
//       Add that edge and the new node to the MST
//
//        Repeat until all nodes are included

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int V = 4;

        int[][] g = {
                {0, 1, 4, 0},
                {1, 0, 0, 2},
                {4, 0, 0, 3},
                {0, 2, 3, 0}
        };

        boolean[] visited = new boolean[V];

        int[] key = new int[V];

        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < V; i++) {
                if (!visited[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (g[u][v] != 0 && !visited[v] && g[u][v] < key[v]) {
                    key[v] = g[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " : " + g[i][parent[i]]);
        }
    }
}





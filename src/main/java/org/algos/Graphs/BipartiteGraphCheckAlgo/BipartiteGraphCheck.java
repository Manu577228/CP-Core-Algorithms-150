package org.algos.Graphs.BipartiteGraphCheckAlgo;

//A Bipartite Graph is a graph whose vertices can be divided into two disjoint sets such that no two
//adjacent vertices belong to the same set.
//The Bipartite Graph Check algorithm verifies this by coloring the graph
//using two colors and ensuring no adjacent nodes share the same color.

//Algorithm Explanation
//
//Assign a color to a starting node.
//
//Traverse the graph using BFS.
//
//Assign opposite colors to adjacent nodes.
//
//If any adjacent nodes have the same color, the graph is not bipartite.

import java.io.*;
import java.util.*;

class Main {

    static boolean isBipartite(int n, List<Integer>[] g) {
        int[] col = new int[n];
        Arrays.fill(col, 0);

        for (int i = 0; i < n; i++) {
            if (col[i] != 0) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            col[i] = 1;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : g[u]) {
                    if (col[v] == 0) {
                        col[v] = -col[u];
                        q.add(v);
                    } else if (col[v] == col[u]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = 4;
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        g[0].add(1);
        g[1].add(0);
        g[1].add(2);
        g[2].add(1);
        g[2].add(3);
        g[3].add(2);
        g[3].add(0);
        g[0].add(3);

        out.println(isBipartite(n, g));
        out.flush();
    }
}

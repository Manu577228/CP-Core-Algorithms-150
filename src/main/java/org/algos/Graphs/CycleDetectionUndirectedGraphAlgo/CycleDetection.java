package org.algos.Graphs.CycleDetectionUndirectedGraphAlgo;

//        Cycle detection in an undirected graph checks whether
//        there exists a path that starts and ends at the same node without reusing an edge.
//        It is commonly solved using DFS with parent tracking.

//         Algorithm Explanation
//
//        Traverse the graph using DFS.
//
//        Maintain a visited[] array to track visited nodes.
//
//        For every node, pass its parent in DFS.
//
//        If an adjacent node is:
//
//        Not visited → DFS recursively.
//
//        Visited and not parent → Cycle detected.
//
//        If DFS finishes without such a case → No cycle.


import java.io.*;
import java.util.*;

class CycleDetectionUndirected {

    static boolean[] visited;
    static int[][] g;

    static boolean dfs(int u, int parent) {
        visited[u] = true;
        for (int v : g[u]) {
            if (!visited[v]) {
                if (dfs(v, u)) return true;
            } else if (v != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {

        g = new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        visited = new boolean[4];

        boolean cycle = false;

        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println(cycle ? "Cycle Detected" : "No Cycle");
    }
}

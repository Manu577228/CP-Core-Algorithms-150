package org.algos.Graphs.TopologicalSortingAlgo;

//        Topological Sorting is a linear ordering of vertices in a
//        Directed Acyclic Graph (DAG) such that for every directed edge u → v,
//        u appears before v.

//      Algorithm Explanation ( Kahn’s Algorithm )
//
//        Works only for DAG
//
//        Compute indegree (incoming edges) for each node
//
//        Push all nodes with indegree = 0 into a queue
//
//        Repeatedly:
//
//        Remove a node from queue
//
//        Add it to answer
//
//        Reduce indegree of its neighbors
//
//        If any neighbor’s indegree becomes 0 → push to queue
//
//        If all nodes are processed → valid topological order

import java.io.*;
import java.util.*;

class TopologicalSort {
    public static void main(String[] args) {
        int V = 4;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}
        };

        List<Integer>[] g = new ArrayList[V];

        for (int i = 0; i < V; i++)
            g[i] = new ArrayList<>();

        for (int[] e : edges)
            g[e[0]].add(e[1]);

        int[] in = new int[V];

        for (int u = 0; u < V; u++)
            for (int v : g[u])
                in[v]++;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < V; i++)
            if (in[i] == 0)
                q.add(i);

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {
            int u = q.poll();
            ans.append(u).append(" ");

            for (int v : g[u]) {
                in[v]--;
                if (in[v] == 0)
                    q.add(v);
            }
        }

        System.out.println(ans.toString());
    }
}

package org.algos.Graphs.FloydWarshallAlgo;

//Floyd–Warshall is an all-pairs shortest path algorithm for weighted graphs.
//        It computes the shortest distance between every pair of vertices, allowing
//        negative weights (no negative cycles).

//            How the Algorithm Works
//
//        Consider every vertex one by one as an intermediate node.
//
//        For each pair (i, j), check:
//
//        Is the path i → k → j shorter than the current known i → j?
//
//        If yes, update the distance.
//
//        Repeat this for all vertices as intermediate nodes.
//
//        After completion, the distance matrix contains shortest paths between all pairs.

import java.io.*;
import java.util.*;

class FloydWarshall {
    public static void main(String[] args) {
        int INF = 1000000000;

        int[][] dist = {
                {0, 3, INF},
                {INF, 0, 5},
                {2, INF, 0}
        };

        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] >= INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }

            System.out.println();
        }
    }
}

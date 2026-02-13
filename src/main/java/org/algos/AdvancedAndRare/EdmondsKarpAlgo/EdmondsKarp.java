package org.algos.AdvancedAndRare.EdmondsKarpAlgo;

//      Edmonds–Karp Algorithm is an implementation of the Ford–Fulkerson
//      method that uses BFS to find the shortest (in edges)
//      augmenting path in a flow network.
//      It guarantees polynomial time by always choosing the minimum-edge
//      path from source to sink.
//
//               Algorithm Explanation
//
//              Treat the graph as a residual graph
//
//              Repeatedly run BFS from source to sink to find an augmenting path
//
//              Push the minimum residual capacity along that path
//
//              Update residual capacities
//
//              Stop when no path exists

import java.io.*;
import java.util.*;

class EdmondsKarp {

    static final int INF = Integer.MAX_VALUE;

    static boolean bfs(int[][] r, int s, int t, int[] p, int n) {
        boolean[] v = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();

        q.add(s);
        v[s] = true;
        p[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int i = 0; i < n; i++) {
                if (!v[i] && r[u][i] > 0) {
                    q.add(i);
                    p[i] = u;
                    v[i] = true;

                    if (i == t)
                        return true;
                }
            }
        }

        return false;
    }

    static int maxFlow(int[][] g, int s, int t, int n) {
        int[][] r = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r[i][j] = g[i][j];

        int[] p = new int[n];

        int mf = 0;

        while (bfs(r, s, t, p, n)) {
            int f = INF;

            for (int v = t; v != s; v = p[v])
                f = Math.min(f, r[p[v]][v]);

            for (int v = t; v != s; v = p[v]) {
                r[p[v]][v] -= f;
                r[v][p[v]] += f;
            }

            mf += f;
        }

        return mf;
    }

    public static void main(String[] args) {
        int[][] g = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        int s = 0, t = 5;

        System.out.println(maxFlow(g, s, t, g.length));
    }
}
